package com.tcs.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cities")
public class City implements Serializable {
	
	private long id;
	private String cityName;
	private String countryName;
  
public City(long id, String cityName, String countryName) {
	super();
	this.id = id;
	this.cityName = cityName;
	this.countryName = countryName;
}
public City() {	  
}

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}

@Column(name = "cityname", nullable = false)
public String getCityName() {
	return cityName;
}
public void setCityName(String cityName) {
	this.cityName = cityName;
}

@Column(name = "countryname", nullable = false)
public String getCountryName() {
	return countryName;
}
public void setCountryName(String countryName) {
	this.countryName = countryName;
}
@Override
public String toString() {
	return "City [id=" + id + ", cityName=" + cityName + ", countryName=" + countryName + "]";
}
  
}
