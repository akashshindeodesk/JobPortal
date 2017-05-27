package com.andre.jobportal.controllers;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.andre.jobportal.domain.Client;
import com.andre.jobportal.services.ClientService;

@Controller
public class ClientController {

	/**
	 * 
	 */
	private ClientService clientService;

	/**
	 * @param traderService
	 */
	@Autowired
	public void setClientService(ClientService traderService) {
		this.clientService = traderService;
	}

	/**
	 * @param client
	 * @return save client
	 */
	@RequestMapping(value = "client", method = RequestMethod.POST)
	public  ResponseEntity<Client>  saveClient(@RequestBody Client client) {
		client.setCreatedDate(new Date(Calendar.getInstance().getTime().getTime()));
		return new ResponseEntity<>(clientService.saveClient(client),HttpStatus.OK);

	}

	/**
	 * @return list of clients
	 */
	@RequestMapping(value = "/clients", method = RequestMethod.GET)
	public  ResponseEntity <List<Client>> list() {
		System.out.println("Returning clients:" +clientService.listAllClients().size());
		ResponseEntity<String> response = null;

		if(clientService.listAllClients().size() >0){
			return new ResponseEntity<>(clientService.listAllClients(),HttpStatus.OK);	
		}else{
			return new ResponseEntity<>(clientService.listAllClients(),HttpStatus.NO_CONTENT);
		}
		
	}

	
}
