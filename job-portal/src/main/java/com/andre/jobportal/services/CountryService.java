package com.andre.jobportal.services;

import com.andre.jobportal.domain.Country;

/**
 * @author akash
 *
 */
public interface CountryService {
	/**
	 * @return list of countries
	 */
	public Iterable<Country> listAllCountries();
}
