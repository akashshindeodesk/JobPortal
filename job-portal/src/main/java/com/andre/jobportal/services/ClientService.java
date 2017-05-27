package com.andre.jobportal.services;

import java.util.List;

import com.andre.jobportal.domain.Client;

public interface ClientService {

	/**
	 * @return
	 */
	List<Client> listAllClients();
	/**
	 * @param client
	 * @return
	 */
	Client saveClient(Client client);
	/**
	 * @param clientId
	 * @return
	 */
	Client getClientById(Double clientId);
}
