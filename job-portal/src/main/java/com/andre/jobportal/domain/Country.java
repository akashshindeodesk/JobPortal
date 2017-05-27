package com.andre.jobportal.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer countryId;

	private String countryName;

	
	/**
	 * @return
	 */
	public Integer getCountryId() {
		return countryId;
	}

	/**
	 * @param countryId
	 */
	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	
	/**
	 * @return
	 */
	public String getCountryName() {
		return countryName;
	}

	/**
	 * @param countryName
	 */
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

}
