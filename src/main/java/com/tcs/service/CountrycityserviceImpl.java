package com.tcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.tcs.model.City;
import com.tcs.model.Country;
import com.tcs.repository.CityRepository;
import com.tcs.repository.CountryRepository;
import com.tcs.util.HazelConfig;

@Service("CountrycityserviceImpl")
//@CacheConfig(cacheNames = "countries")

public class CountrycityserviceImpl implements Countrycityservice {

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	HazelConfig hazelConfig;

	@Override
	@Cacheable(value = "countries")
	public List<Country> getAllCountries() {
		System.out.println("DB CALL COUNTRY");
		IMap<Object, Object> asd = hazelConfig.getMapConfig("countries");
		List<Country> countriesList = countryRepository.findAll();
		for (Country ctry : countriesList) {
			asd.put(ctry.getName(), ctry);
		}
		
		return countriesList;
	}

	@Override
	@Cacheable(value = "cities")
	public List<City> getAllCities() {
		System.out.println("DB CALL CITY");
		List<City> cities = cityRepository.findAll();
		IMap<Object, Object> cityStore = hazelConfig.getMapConfig("cities");
		for (City cty : cities) {
			cityStore.put(cty.getCityName(), cty);
		}
		 
		return cities;
	}
	
	
//	public dynamicAddCache
	

}
