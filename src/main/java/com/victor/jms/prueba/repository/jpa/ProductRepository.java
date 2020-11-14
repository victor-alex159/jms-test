package com.victor.jms.prueba.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.victor.jms.prueba.entity.ProductEntity;

public interface ProductRepository extends PagingAndSortingRepository<ProductEntity, Integer> {

}
