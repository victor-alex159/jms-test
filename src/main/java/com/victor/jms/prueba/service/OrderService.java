package com.victor.jms.prueba.service;

import java.util.List;
import java.util.Map;

import com.victor.jms.prueba.entity.OrderEntity;

public interface OrderService {
	
	abstract OrderEntity saveOrder(OrderEntity order);
	abstract OrderEntity responseOrder(OrderEntity order);
	abstract List<Map<String, Object>> getOrder(OrderEntity order);

}
