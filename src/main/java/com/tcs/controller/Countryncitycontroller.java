package com.tcs.controller;

import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hazelcast.config.MapConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.tcs.model.City;
import com.tcs.model.Country;
import com.tcs.service.Countrycityservice;
import com.tcs.util.HazelConfig;



@RestController
@RequestMapping("/management")
public class Countryncitycontroller {
	private static final Object India = null;
	@Autowired
	Countrycityservice countrycityservice;
	@Autowired
	HazelConfig hazelConfig;
	
	@GetMapping("/getAllCountries")
	@Consumes("application/json")
	@Produces("application/json")
	public List<Country> getCountries()  {
		List<Country> coutries=countrycityservice.getAllCountries();	
//		HazelcastInstance hazelcastInstanceByName = Hazelcast.getHazelcastInstanceByName("hazelcast-instance");
		IMap<Object, Object> country = hazelConfig.getCacheDetails("countries");	
		Object object = country.get("India");
		System.out.println(object);		
	    return coutries;
		}
	

	@GetMapping("/getAllCities")
	@Consumes("application/json")
	@Produces("application/json")
	public List<City> getCities()  {
		List<City> cities=countrycityservice.getAllCities();
		IMap<Object, Object> city = hazelConfig.getCacheDetails("cities");
		Object object2 = city.get("Kolkata");
		System.out.println(object2);
	    return cities;
	      
		}
	
	@GetMapping("/clearCache")
	@Consumes("application/json")
	@Produces("application/json")
	public boolean reloadCache(@RequestParam(value = "cacheName") String cacheName)  {
		
		boolean result=false;
		
		IMap<Object, Object> myCache = hazelConfig.getCacheDetails(cacheName);
		if(myCache!=null) {
			myCache.destroy();
			result=true;
		}
	

	    return result;
	      
		}	
}
