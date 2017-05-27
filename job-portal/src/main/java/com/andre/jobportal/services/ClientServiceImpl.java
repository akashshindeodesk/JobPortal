package com.andre.jobportal.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andre.jobportal.domain.Client;
import com.andre.jobportal.repositories.ClientRepository;

/**
 * @author akash
 *
 */
@Service
public class ClientServiceImpl implements ClientService {

	private ClientRepository clientRepository;

	/**
	 * @param repository
	 */
	@Autowired
	public void setClientRepository(ClientRepository repository) {
		this.clientRepository = repository;
	}

	/* (non-Javadoc)
	 * @see com.andre.jobportal.services.ClientService#listAllClients()
	 */
	@Override
	public List<Client> listAllClients() {
		List<Client> clients  =  new ArrayList<>();
		for(Client c: clientRepository.findAll()){
			clients.add(c);
		}
		return clients;
	}

	/* (non-Javadoc)
	 * @see com.andre.jobportal.services.ClientService#saveClient(com.andre.jobportal.domain.Client)
	 */
	@Override
	public Client saveClient(Client client) {
		return clientRepository.save(client);
	}

	/* (non-Javadoc)
	 * @see com.andre.jobportal.services.ClientService#getClientById(java.lang.Double)
	 */
	@Override
	public Client getClientById(Double clientId) {
		Double d = clientId;
		Integer id = d.intValue();
		return clientRepository.findOne(id);
	}

}
