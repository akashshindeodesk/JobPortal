package com.andre.jobportal.services;


import com.andre.jobportal.domain.Traders;

/**
 * @author akash
 *
 */
public interface TradersService {
    /**
     * @return
     */
    Iterable<Traders> listAllTrades();

    /**
     * @param id
     * @return
     */
    Traders getProductById(Integer id);

    /**
     * @param product
     * @return
     */
    Traders saveTrade(Traders product);

	/**
	 * @return
	 */
	int getAllTradesSize();
}
