package com.victor.jms.prueba.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.jms.prueba.entity.OrderEntity;
import com.victor.jms.prueba.entity.ProductEntity;
import com.victor.jms.prueba.messaging.Sender;
import com.victor.jms.prueba.repository.jpa.OrderJpaRepository;
import com.victor.jms.prueba.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderJpaRepository orderRepository;
	
	@Autowired
	private Sender messageSender;

	@Override
	public OrderEntity saveOrder(OrderEntity order) {
		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setName(order.getName());
		orderEntity.setLastname(order.getLastname());
		orderEntity.setSurname(order.getSurname());
		orderEntity.setDocumentNumber(order.getDocumentNumber());
		orderEntity.setStatus(order.getStatus());
		orderEntity.setProduct(new ProductEntity());
		orderEntity.getProduct().setId(order.getProduct().getId());
		orderRepository.save(orderEntity);
		messageSender.sendMessage(order);
		return orderEntity;
	}

	@Override
	public OrderEntity responseOrder(OrderEntity order) {
		OrderEntity orderEntity = new OrderEntity();
		orderEntity = orderRepository.findById(order.getId()).orElse(null);
		orderEntity.setStatus(order.getStatus());
		orderRepository.save(orderEntity);
		messageSender.sendMessage(order);
		return orderEntity;
	}

	@Override
	public List<Map<String, Object>> getOrder(OrderEntity order) {
		List<Object[]> listResult = orderRepository.getOrder(order);
		
		if(listResult != null) {
			List<Map<String, Object>> result = new ArrayList<>();
			listResult.forEach(response -> {
				Map<String, Object> map = new HashMap<>();
				map.put("name", response[0]);
				map.put("lastname", response[1]);
				map.put("surname", response[2]);
				map.put("documentNumber", response[3]);
				map.put("productName", response[4]);
				map.put("priceProduct", response[5]);
				result.add(map);
			});
			return result;
		}
		
		return null;
	}

}
