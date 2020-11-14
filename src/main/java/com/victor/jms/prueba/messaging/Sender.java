package com.victor.jms.prueba.messaging;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import com.victor.jms.prueba.entity.OrderEntity;

@Component
public class Sender {
	
	@Autowired
    JmsTemplate jmsTemplate;
	
	public void sendMessage(final OrderEntity order) {
		jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException{
                ObjectMessage objectMessage = session.createObjectMessage(order);
                return objectMessage;
            }
        });
	}

}
