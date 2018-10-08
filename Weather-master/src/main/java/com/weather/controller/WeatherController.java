package com.weather.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weather.entities.WeatherData;
import com.weather.models.WeatherInformation;
import com.weather.service.WeatherService;

@RequestMapping("/weatherForecast")
@RestController
public class WeatherController {
	
	@Autowired
	private WeatherService weatherService;
	
	@GetMapping("/weather")
	public List<WeatherInformation> getWeatherInApi() {
		return weatherService.getWeatherInfo();
	}
	
	@GetMapping("/saveWeather")
	public void saveWeather() {
		weatherService.saveWeatherInfo();
	}
	
	@GetMapping("/weatherData")
	public List<WeatherData> getWeatherDataInDB() {
		return weatherService.getDatabaseValues();
	}

}
