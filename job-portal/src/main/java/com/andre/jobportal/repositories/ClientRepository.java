package com.andre.jobportal.repositories;

import org.springframework.data.repository.CrudRepository;

import com.andre.jobportal.domain.Client;


/**
 * @author akash
 *
 */
public interface ClientRepository extends CrudRepository<Client, Integer>{

}