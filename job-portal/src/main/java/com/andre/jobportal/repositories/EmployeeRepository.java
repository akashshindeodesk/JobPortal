package com.andre.jobportal.repositories;

import org.springframework.data.repository.CrudRepository;

import com.andre.jobportal.domain.Employee;

/**
 * @author akash
 *
 */
public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

}