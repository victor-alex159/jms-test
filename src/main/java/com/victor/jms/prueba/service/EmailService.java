package com.victor.jms.prueba.service;

import com.victor.jms.prueba.entity.EmailEntity;

public interface EmailService {
	
	abstract EmailEntity sendMessage(EmailEntity email);

}
