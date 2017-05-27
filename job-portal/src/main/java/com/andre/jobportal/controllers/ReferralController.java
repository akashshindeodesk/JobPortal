package com.andre.jobportal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.andre.jobportal.domain.Referral;
import com.andre.jobportal.services.ReferralService;

/**
 * @author akash
 *
 */
@Controller
public class ReferralController {

	/**
	 * 
	 */
	private ReferralService referralService;

	/**
	 * @param rService
	 */
	@Autowired
	public void setCountryService(ReferralService rService) {
		this.referralService = rService;
	}

	/**
	 * @return list of referrals
	 */
	@RequestMapping(value = "/referrals", method = RequestMethod.GET)
	public ResponseEntity<List<Referral>> list() {
		if (referralService.listAllReferral().size() > 0) {
			return new ResponseEntity<List<Referral>>(referralService.listAllReferral(), HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Referral>>(referralService.listAllReferral(), HttpStatus.NO_CONTENT);
		}
	}

	/**
	 * @param referral
	 * @return Referral saved object
	 */
	@RequestMapping(value = "/newreferal", method = RequestMethod.POST)
	 public ResponseEntity <Referral> saveReferral(@RequestBody Referral referral) {
		
		Referral ref = referralService.saveReferral(referral);
		if(ref == null){
		return new ResponseEntity<>(ref,HttpStatus.OK);	
		}else{
			return new ResponseEntity<>(ref,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
