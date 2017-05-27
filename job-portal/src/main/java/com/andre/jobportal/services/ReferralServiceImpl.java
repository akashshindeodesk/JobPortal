package com.andre.jobportal.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andre.jobportal.domain.Referral;
import com.andre.jobportal.repositories.ReferealRepository;

/**
 * @author akash
 *
 */
@Service
public class ReferralServiceImpl implements ReferralService {

	/**
	 * 
	 */
	private ReferealRepository referralRepository;

	/**
	 * @param rRepository
	 */
	@Autowired
	public void setReferealRepository(ReferealRepository rRepository) {
		this.referralRepository = rRepository;
	}

	/* (non-Javadoc)
	 * @see com.andre.jobportal.services.ReferralService#listAllReferral()
	 */
	@Override
	public List<Referral> listAllReferral() {
		List<Referral> list = new ArrayList<>();
		for (Referral r : referralRepository.findAll()) {
			list.add(r);
		}
		return list;
	}

	
	/* (non-Javadoc)
	 * @see com.andre.jobportal.services.ReferralService#saveReferral(com.andre.jobportal.domain.Referral)
	 */
	@Override
	public Referral saveReferral(Referral referral) {
		return referralRepository.save(referral);
	}

	/* (non-Javadoc)
	 * @see com.andre.jobportal.services.ReferralService#getReferralById(java.lang.Double)
	 */
	@Override
	public Referral getReferralById(Double clientId) {
		return null;
	}

}
