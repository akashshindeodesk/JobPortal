package com.andre.jobportal.repositories;

import org.springframework.data.repository.CrudRepository;

import com.andre.jobportal.domain.InvoiceName;


/**
 * @author akash
 *
 */
public interface InvoiceRepository extends CrudRepository<InvoiceName, Integer>{

}