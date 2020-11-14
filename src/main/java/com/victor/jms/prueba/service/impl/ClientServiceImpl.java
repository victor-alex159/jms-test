package com.victor.jms.prueba.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.jms.prueba.entity.ClientEntity;
import com.victor.jms.prueba.repository.jpa.ClientRepository;
import com.victor.jms.prueba.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	@Override
	public ClientEntity saveClient(ClientEntity client) {
		ClientEntity clientEntity = new ClientEntity();
		clientEntity.setName(client.getName());
		clientEntity.setLastname(client.getLastname());
		clientEntity.setSurname(client.getSurname());
		clientEntity.setDocumentNumber(client.getDocumentNumber());
		clientRepository.save(clientEntity);
		
		return clientEntity;
	}
	
	
}
