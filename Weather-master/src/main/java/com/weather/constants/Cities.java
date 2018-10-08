package com.weather.constants;

public enum Cities {

	LONDON("London", "2643743"), PRAGUE("Prague", "3067696"), SAN_FRANCISCO("San Francisco", "5391959");

	private String name;

	private String cityCode;

	Cities(String name, String value) {
		this.name = name;
		this.cityCode = value;
	}

	public String getName() {
		return name;
	}

	public String getCityCode() {
		return cityCode;
	}

}
