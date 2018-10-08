package com.weather.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Temperature {

	public Temperature() {
	}

	@JsonProperty("temp")
	private Integer temp;

	@JsonProperty("temp_min")
	private Integer tempMin;

	@JsonProperty("temp_max")
	private Integer tempMax;

	public Integer getTemp() {
		return temp;
	}

	public void setTemp(Integer temp) {
		this.temp = temp;
	}

	public Integer getTempMin() {
		return tempMin;
	}

	public void setTempMin(Integer tempMin) {
		this.tempMin = tempMin;
	}

	public Integer getTempMax() {
		return tempMax;
	}

	public void setTempMax(Integer tempMax) {
		this.tempMax = tempMax;
	}
	
	@Override
	public String toString() {
		return "temp=" + temp + ", tempMin=" + tempMin + ", tempMax=" + tempMax;
	}

}
