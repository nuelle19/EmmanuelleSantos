package com.weather.repositories;

import org.springframework.data.repository.CrudRepository;

import com.weather.entities.WeatherData;

public interface WeatherRepository extends CrudRepository<WeatherData, Long>{
	
}
