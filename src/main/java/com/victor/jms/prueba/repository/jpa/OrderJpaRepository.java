package com.victor.jms.prueba.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.victor.jms.prueba.entity.OrderEntity;

public interface OrderJpaRepository extends PagingAndSortingRepository<OrderEntity, Integer>, OrderJpaRepositoryCustom {

}
