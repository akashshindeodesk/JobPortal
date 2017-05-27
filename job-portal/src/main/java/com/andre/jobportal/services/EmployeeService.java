package com.andre.jobportal.services;

import java.util.List;

import com.andre.jobportal.domain.Employee;

/**
 * @author akash
 *
 */
public interface EmployeeService {

	/**
	 * @return list of employees
	 */
	List<Employee> listAllEmployee();
}
