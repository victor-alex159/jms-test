package com.victor.jms.prueba.messaging;

import javax.jms.JMSException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

import com.victor.jms.prueba.entity.OrderEntity;
import com.victor.jms.prueba.service.OrderService;

@Component
public class Receiver {

	public static final Logger logger = LoggerFactory.getLogger(Receiver.class);
	public static final String ORDER_RESPONSE_QUEUE = "order-response-queue";
	
	@Autowired
	private OrderService orderService;
	
	@JmsListener(destination = ORDER_RESPONSE_QUEUE)
	public void receiveMessage(final Message<OrderEntity> message) throws JMSException {
		MessageHeaders headers = message.getHeaders();
		logger.info("Application : headers received : {}", headers);
		
		OrderEntity orderResponse = message.getPayload();
		logger.info("Application : response received : {}", orderResponse);
		
		orderService.responseOrder(orderResponse);
		//System.out.println("Received <" + message + ">");
	}
	
}
