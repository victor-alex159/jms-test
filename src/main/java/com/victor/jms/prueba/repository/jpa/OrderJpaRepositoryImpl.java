package com.victor.jms.prueba.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.victor.jms.prueba.entity.OrderEntity;

public class OrderJpaRepositoryImpl implements OrderJpaRepositoryCustom {

	@PersistenceContext()
	private EntityManager em;
	
	@Override
	public List<Object[]> getOrder(OrderEntity orderEntity) {
		StringBuffer queryStr = new StringBuffer("SELECT od.name as nombre, od.lastname, od.surname, od.document_number, pr.name, pr.price ");
		queryStr.append(" FROM order_detail od INNER JOIN product pr ON od.product_id=pr.id ");
		
		Query query = em.createNativeQuery(queryStr.toString());
		
		return query.getResultList();
	}

}
