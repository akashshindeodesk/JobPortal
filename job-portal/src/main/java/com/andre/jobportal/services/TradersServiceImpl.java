package com.andre.jobportal.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andre.jobportal.domain.Traders;
import com.andre.jobportal.repositories.TradersRepository;

/**
 * @author akash
 *
 */
@Service
public class TradersServiceImpl implements TradersService {
    /**
     * 
     */
    private TradersRepository tradersRepository;

    /**
     * @param productRepository
     */
    @Autowired
    public void setTradersRepository(TradersRepository productRepository) {
        this.tradersRepository = productRepository;
    }

    /* (non-Javadoc)
     * @see com.andre.jobportal.services.TradersService#listAllTrades()
     */
    @Override
    public Iterable<Traders> listAllTrades() {
        return tradersRepository.findAll();
    }

    /* (non-Javadoc)
     * @see com.andre.jobportal.services.TradersService#getProductById(java.lang.Integer)
     */
    @Override
    public Traders getProductById(Integer id) {
        return tradersRepository.findOne(id);
    }

    /* (non-Javadoc)
     * @see com.andre.jobportal.services.TradersService#saveTrade(com.andre.jobportal.domain.Traders)
     */
    @Override
    public Traders saveTrade(Traders product) {
        return tradersRepository.save(product);
    }

	/* (non-Javadoc)
	 * @see com.andre.jobportal.services.TradersService#getAllTradesSize()
	 */
	@Override
	public int getAllTradesSize() {
		tradersRepository.findAll();
		List<Traders> list =  new ArrayList<>();
		for(Traders t : tradersRepository.findAll()){
			list.add(t);
		}
		return list.get(list.size()-1).getId();
	}
	
}
