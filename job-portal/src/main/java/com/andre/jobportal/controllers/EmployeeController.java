package com.andre.jobportal.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.andre.jobportal.domain.Employee;
import com.andre.jobportal.services.EmployeeService;

/**
 * @author akash
 *
 */
@Controller
public class EmployeeController {

	/**
	 * 
	 */
	private EmployeeService employeeService;

	/**
	 * @param employeeService
	 */
	@Autowired
	public void setProductService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	/**
	 * @return list of employees
	 */
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public ResponseEntity< List<Employee> >list() {
		if(employeeService.listAllEmployee().size() >0){
			return new ResponseEntity<>(employeeService.listAllEmployee(),HttpStatus.OK);
		}else{
                return new ResponseEntity<List<Employee>>(employeeService.listAllEmployee(),HttpStatus.NO_CONTENT);
		}
	}
}
