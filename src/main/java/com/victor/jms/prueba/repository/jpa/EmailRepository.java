package com.victor.jms.prueba.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.victor.jms.prueba.entity.EmailEntity;

public interface EmailRepository extends PagingAndSortingRepository<EmailEntity, Integer> {

}
