package com.victor.jms.prueba.repository.jpa;

import java.util.List;

import com.victor.jms.prueba.entity.OrderEntity;

public interface OrderJpaRepositoryCustom {
	
	abstract public List<Object[]> getOrder(OrderEntity orderEntity);

}
