package com.victor.jms.prueba.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.victor.jms.prueba.entity.ClientEntity;
import com.victor.jms.prueba.service.ClientService;
import com.victor.jms.prueba.soa.request.GenericRequest;
import com.victor.jms.prueba.soa.response.GenericResponse;

@RestController
@RequestMapping(value = "/client")
public class ClientController {
	
	private static final Logger logger = LogManager.getLogger(EmailController.class);
	
	@Autowired
	private ClientService clientService;
	
	@RequestMapping(value = "/sc", method = RequestMethod.POST)
	public GenericResponse<ClientEntity> saveClient(@RequestBody GenericRequest<ClientEntity> request) {
		logger.info("ClientController.saveClient()");
		GenericResponse<ClientEntity> response = new GenericResponse<>();
		ClientEntity client = clientService.saveClient(request.getData());
		response.setData(client);
		return response;
	}

}
