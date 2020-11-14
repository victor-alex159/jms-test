package com.victor.jms.prueba.controller;

import java.util.List;import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.victor.jms.prueba.entity.OrderEntity;
import com.victor.jms.prueba.service.OrderService;
import com.victor.jms.prueba.soa.request.GenericRequest;
import com.victor.jms.prueba.soa.response.GenericResponse;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping(value = "/ord")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	private static final Logger logger = LogManager.getLogger(OrderController.class);

	@RequestMapping(value = "/so", method = RequestMethod.POST)
	public GenericResponse<OrderEntity> saveOrder(@RequestBody GenericRequest<OrderEntity> request) {
		logger.info("OrderController.saveOrder()");
		GenericResponse<OrderEntity> response = new GenericResponse<>();
		OrderEntity order = orderService.saveOrder(request.getData());
		response.setData(order);
		return response;
	}
	
	@RequestMapping(value = "/uo", method = RequestMethod.POST)
	public GenericResponse<OrderEntity> updateOrder(@RequestBody GenericRequest<OrderEntity> request) {
		logger.info("OrderController.updateOrder()");
		GenericResponse<OrderEntity> response = new GenericResponse<>();
		OrderEntity order = orderService.responseOrder(request.getData());
		response.setData(order);
		return response;
	}
	
	@RequestMapping(value = "/go", method = RequestMethod.POST)
	public GenericResponse<List<Map<String, Object>>> getOrder(@RequestBody GenericRequest<OrderEntity> request) {
		logger.info("OrderController.getOrder()");
		GenericResponse<List<Map<String, Object>>> response = new GenericResponse<>();
		List<Map<String, Object>> order = orderService.getOrder(request.getData());
		response.setData(order);
		return response;
	}
}
