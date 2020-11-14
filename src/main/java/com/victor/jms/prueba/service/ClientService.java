package com.victor.jms.prueba.service;

import com.victor.jms.prueba.entity.ClientEntity;

public interface ClientService {

	abstract ClientEntity saveClient(ClientEntity client);
	
}
