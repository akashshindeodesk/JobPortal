package com.andre.jobportal.services;

import com.andre.jobportal.domain.Benefieciary;

public interface BenefiencyService {

	/**
	 * @return
	 */
	Iterable<Benefieciary> listAllBenefieciary();
	/**
	 * @param benefieciar
	 * @return
	 */
	Benefieciary saveBenefieciary(Benefieciary benefieciar);
	/**
	 * @param clientId
	 * @return
	 */
	Benefieciary getBeneficiaryById(Double clientId);

}
