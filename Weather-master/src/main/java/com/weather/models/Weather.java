package com.weather.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {

	public Weather() {
	}

	@JsonProperty("main")
	private String weather;

	@JsonProperty("description")
	private String description;

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public String getDesc() {
		return description;
	}

	public void setDesc(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "weather=" + weather + ", description=" + description;
	}
	
}
