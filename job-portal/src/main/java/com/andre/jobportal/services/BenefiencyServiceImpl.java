package com.andre.jobportal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andre.jobportal.domain.Benefieciary;
import com.andre.jobportal.repositories.BeneFiencyRepository;

@Service
public class BenefiencyServiceImpl implements BenefiencyService {

	private BeneFiencyRepository beneFiencyRepository;

	/**
	 * @param beneFiencyRepository
	 */
	@Autowired
	public void setBeneFiencyRepository(BeneFiencyRepository beneFiencyRepository) {
		this.beneFiencyRepository = beneFiencyRepository;
	}

	/* (non-Javadoc)
	 * @see com.andre.jobportal.services.BenefiencyService#listAllBenefieciary()
	 */
	@Override
	public Iterable<Benefieciary> listAllBenefieciary() {
		return beneFiencyRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see com.andre.jobportal.services.BenefiencyService#saveBenefieciary(com.andre.jobportal.domain.Benefieciary)
	 */
	@Override
	public Benefieciary saveBenefieciary(Benefieciary benefieciar) {
		return beneFiencyRepository.save(benefieciar);
	}

	/* (non-Javadoc)
	 * @see com.andre.jobportal.services.BenefiencyService#getBeneficiaryById(java.lang.Double)
	 */
	@Override
	public Benefieciary getBeneficiaryById(Double clientId) {
		Double d = clientId;
		Integer id = d.intValue();
		return beneFiencyRepository.findOne(id);
	}

}
