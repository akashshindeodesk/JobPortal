package com.andre.jobportal.repositories;

import org.springframework.data.repository.CrudRepository;

import com.andre.jobportal.domain.Country;

/**
 * @author akash
 *
 */
public interface CountryRepository extends CrudRepository<Country, Integer>{

}