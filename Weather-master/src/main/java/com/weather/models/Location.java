package com.weather.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {

	public Location() {
	}

	@JsonProperty("lon")
	private Integer longitude;

	@JsonProperty("lat")
	private Integer latitude;

	public Integer getLongitude() {
		return longitude;
	}

	public void setLongitude(Integer longitude) {
		this.longitude = longitude;
	}

	public Integer getLatitude() {
		return latitude;
	}

	public void setLatitude(Integer latitude) {
		this.latitude = latitude;
	}
	
	@Override
	public String toString() {
		return "longitude=" + longitude + ", latitude=" + latitude;
	}

}
