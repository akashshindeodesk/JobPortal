package com.andre.jobportal.services;

import java.util.List;

import com.andre.jobportal.domain.Referral;

/**
 * @author akash
 *
 */
public interface ReferralService {

	/**
	 * @return
	 */
	List<Referral> listAllReferral();
	/**
	 * @param refereal
	 * @return
	 */
	Referral saveReferral(Referral refereal);
	/**
	 * @param refId
	 * @return
	 */
	Referral getReferralById(Double refId);
}
