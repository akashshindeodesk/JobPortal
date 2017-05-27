package com.andre.jobportal.controllers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.andre.jobportal.domain.Benefieciary;
import com.andre.jobportal.services.BenefiencyService;

/**
 * @author akash
 *
 */
@Controller
public class BeneficialController {

	/**
	 * 
	 */
	private BenefiencyService benefiencyService;

	/**
	 * @param traderService
	 */
	@Autowired
	public void setBenefiencyService(BenefiencyService traderService) {
		this.benefiencyService = traderService;
	}

	/**
	 * This method is used to save the new Beneficy
	 * @param beneficy
	 * @return
	 */
	@RequestMapping(value = "beneficy", method = RequestMethod.POST)
	public ResponseEntity<Benefieciary> saveBeneficy(@RequestBody Benefieciary beneficy) {
		beneficy.setCreatedDate(new Date(Calendar.getInstance().getTime().getTime()));
		Benefieciary benefieciary = benefiencyService.saveBenefieciary(beneficy);
		if (benefieciary != null) {
			return new ResponseEntity<>(beneficy,HttpStatus.OK);
		} else {
			return new ResponseEntity<>(beneficy,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * @return list of beneficy
	 */
	@RequestMapping(value = "/benefies", method = RequestMethod.GET)
	public ResponseEntity<List<Benefieciary>> list() {

		List<Benefieciary> list = new ArrayList<>();

		for (Benefieciary b : benefiencyService.listAllBenefieciary()) {
			list.add(b);
		}

		if (list.size() > 0) {
			return new ResponseEntity<List<Benefieciary>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Benefieciary>>(list, HttpStatus.NO_CONTENT);
		}
	}

}
