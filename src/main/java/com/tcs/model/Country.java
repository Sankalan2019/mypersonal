package com.tcs.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "countries")
public class Country implements Serializable {
  private long id;
  private String name;
  private String capital;
  private String currencyName;
  
  public Country() {
	  
  }

  public Country(String name, String capital, String currencyName) {
       this.name = name;
       this.capital = capital;
       this.currencyName = currencyName;
 
  }

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "capital", nullable = false)
	public String getCapital() {
		return capital;
	}
	
	public void setCapital(String capital) {
		this.capital = capital;
	}
	
	@Column(name = "currencyname", nullable = false)
	public String getCurrencyName() {
		return currencyName;
	}
	
	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + ", capital=" + capital + ", currencyName=" + currencyName + "]";
	}
	  
  
}

