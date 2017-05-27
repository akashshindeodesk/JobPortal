package com.andre.jobportal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andre.jobportal.domain.Country;
import com.andre.jobportal.repositories.CountryRepository;

/**
 * @author akash
 *
 */
@Service
public class CountryServiceImpl implements CountryService {

	private CountryRepository countryRepository;

	/**
	 * @param countryRepository
	 */
	@Autowired
	public void setCountryRepository(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.andre.jobportal.services.CountryService#listAllCountries()
	 */
	@Override
	public Iterable<Country> listAllCountries() {
		return countryRepository.findAll();
	}

}
