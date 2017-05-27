package com.andre.jobportal.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andre.jobportal.domain.Employee;
import com.andre.jobportal.repositories.EmployeeRepository;

/**
 * @author akash
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	/**
	 * @param repository
	 */
	@Autowired
	public void setEmployeeRepository(EmployeeRepository repository) {
		this.employeeRepository = repository;
	}

	/* (non-Javadoc)
	 * @see com.andre.jobportal.services.EmployeeService#listAllEmployee()
	 */
	@Override
	public List<Employee> listAllEmployee() {
		List<Employee> employees  =  new ArrayList<>();
		for(Employee e: employeeRepository.findAll()){
			employees.add(e);
		}
		return employees;
	}

}
