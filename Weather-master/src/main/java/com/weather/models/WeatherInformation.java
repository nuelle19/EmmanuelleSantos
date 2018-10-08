package com.weather.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherInformation {

	public WeatherInformation() {
	}

	@JsonProperty("name")
	private String name;
	
	@JsonProperty("id")
	private Long id;

	@JsonProperty("coord")
	private Location location;

	@JsonProperty("weather")
	private List<Weather> weather;

	@JsonProperty("main")
	private Temperature temperature;

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLocation() {
		return location.toString();
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getWeather() {
		return weather.toString();
	}

	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}

	public String getTemperature() {
		return temperature.toString();
	}

	public void setTemperature(Temperature temperature) {
		this.temperature = temperature;
	}

	@Override
	public String toString() {
		return "name=" + name + ", id=" + id + ", location=" + location + ", weather=" + weather + ", temperature=" + temperature;
	}
}
