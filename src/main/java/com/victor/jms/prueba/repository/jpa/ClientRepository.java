package com.victor.jms.prueba.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.victor.jms.prueba.entity.ClientEntity;

public interface ClientRepository extends PagingAndSortingRepository<ClientEntity, Integer> {

}
