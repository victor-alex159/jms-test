package com.victor.jms.prueba.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.victor.jms.prueba.JmsPruebaApplication;
import com.victor.jms.prueba.entity.EmailEntity;
import com.victor.jms.prueba.repository.jpa.EmailRepository;
import com.victor.jms.prueba.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private EmailRepository emailRepository;
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Override
	public EmailEntity sendMessage(EmailEntity email) {
		EmailEntity emailEntity = new EmailEntity();
		emailEntity.setToReceive(email.getToReceive());
		emailEntity.setBody(email.getBody());
		emailRepository.save(emailEntity);
		//jmsTemplate.convertAndSend(JmsPruebaApplication.destination, emailEntity);
		return emailEntity;
	}
	

}
