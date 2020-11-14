package com.victor.jms.prueba.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.victor.jms.prueba.entity.UserEntity;

public interface UserRepository extends PagingAndSortingRepository<UserEntity, Integer> {

}
