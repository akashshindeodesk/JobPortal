package com.andre.jobportal.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.andre.jobportal.domain.Country;
import com.andre.jobportal.services.CountryService;

/**
 * @author akash
 *
 */
@Controller
public class CountryController {

	/**
	 * 
	 */
	private CountryService countryService;

	/**
	 * @param cService
	 */
	@Autowired
	public void setCountryService(CountryService cService) {
		this.countryService = cService;
	}

	/**
	 * @return list of countries
	 */
	@RequestMapping(value = "/countries", method = RequestMethod.GET)
	public ResponseEntity<List<Country>> list() {
		List<Country> list = new ArrayList<>();
		for (Country c : countryService.listAllCountries()) {
			list.add(c);

		}
		if (list.size() > 0) {
			return new ResponseEntity<>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(list, HttpStatus.NO_CONTENT);
		}
	}

}
