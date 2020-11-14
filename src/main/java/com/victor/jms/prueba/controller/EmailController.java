package com.victor.jms.prueba.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.victor.jms.prueba.entity.EmailEntity;
import com.victor.jms.prueba.service.EmailService;
import com.victor.jms.prueba.soa.request.GenericRequest;
import com.victor.jms.prueba.soa.response.GenericResponse;

@RestController
@RequestMapping(value = "/message")
public class EmailController {
	
	private static final Logger logger = LogManager.getLogger(EmailController.class);
	
	@Autowired
	private EmailService emailService;
	
	@RequestMapping(value = "/sm", method = RequestMethod.POST)
	public GenericResponse<EmailEntity> sendMessage(@RequestBody GenericRequest<EmailEntity> request) {
		logger.info("EmailController.sendMessage()");
		GenericResponse<EmailEntity> response = new GenericResponse<EmailEntity>();
		EmailEntity emailEntity = emailService.sendMessage(request.getData());
		response.setData(emailEntity);
		return response;
	}

}
