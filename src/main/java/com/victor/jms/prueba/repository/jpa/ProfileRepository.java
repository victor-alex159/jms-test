package com.victor.jms.prueba.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.victor.jms.prueba.entity.ProfileEntity;

public interface ProfileRepository extends PagingAndSortingRepository<ProfileEntity, Integer> {

}
