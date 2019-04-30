package com.tcs.service;

import java.util.List;

import com.tcs.model.City;
import com.tcs.model.Country;

public interface Countrycityservice {
	
	public List<Country> getAllCountries();
	public List<City> getAllCities();

}
