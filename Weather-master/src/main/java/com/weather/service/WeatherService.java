package com.weather.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.weather.constants.Cities;
import com.weather.entities.WeatherData;
import com.weather.models.WeatherInformation;
import com.weather.repositories.WeatherRepository;

@Service
public class WeatherService {

	private static final String URL = "https://api.openweathermap.org/data/2.5/weather?id=%s&units=metric&APPID=%s";

	private static final String APP_ID = "56af446e5adb1593d402c69b9a1b13a4";

	@Autowired
	private WeatherRepository weatherRepository;

	private RestTemplate restTemplate = new RestTemplate();

	private List<WeatherInformation> weatherInformationList = new ArrayList<>();

	public List<WeatherInformation> getWeatherInfo() {
		for (Cities city : Cities.values()) {
			WeatherInformation weatherInformation = restTemplate.getForObject(createWeatherUrl(city.getCityCode()),
					WeatherInformation.class);
			weatherInformationList.add(weatherInformation);
		}
		return weatherInformationList;
	}

	public void saveWeatherInfo() {
		for (WeatherInformation weatherInformation : weatherInformationList) {
			if (isWithinDatabaseLimit() && !isIdExistInDatabase(weatherInformation)) {
				WeatherData weatherData = new WeatherData();
				weatherData.setResponseId(String.valueOf(weatherInformation.getId()));
				weatherData.setLocation(weatherInformation.getLocation());
				weatherData.setActualWeather(weatherInformation.getWeather());
				weatherData.setTemperature(weatherInformation.getTemperature());
				weatherData.setDtimeInserted(new Timestamp(System.currentTimeMillis()));
				weatherRepository.save(weatherData);
			}
		}
	}

	public List<WeatherData> getDatabaseValues() {
		return getAllValues();
	}

	private String createWeatherUrl(String cityId) {
		String uri = String.format(URL, cityId, APP_ID);
		return uri;
	}

	private boolean isIdExistInDatabase(WeatherInformation weatherInformation) {
		return weatherRepository.findById(weatherInformation.getId()).isPresent();
	}

	private boolean isWithinDatabaseLimit() {
		List<WeatherData> weatherDataList = getAllValues();
		final int SAVE_LIMIT = 5;
		return weatherDataList.size() < SAVE_LIMIT;
	}

	private List<WeatherData> getAllValues() {
		List<WeatherData> weatherDataList = new ArrayList<>();
		weatherRepository.findAll().forEach(weatherDataList::add);
		return weatherDataList;
	}

}
