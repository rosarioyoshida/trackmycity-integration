package br.com.trackmycity.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

public class CommonOperationsDAO<T, ID> {
	
	private CriteriaBuilder criteriaBuilder;
	private CriteriaQuery<T> criteriaQuery;
	private Root<T> root;
	private EntityManager em;
	private Class<T> entityClass;
	
	public CommonOperationsDAO(EntityManager em, Class<T> entityClass) {
		super();
		this.em = em;
		this.entityClass = entityClass;
		this.criteriaBuilder = this.em.getCriteriaBuilder();
		this.criteriaQuery = this.criteriaBuilder.createQuery(entityClass);
		this.root = this.criteriaQuery.from(entityClass);
	}
	
	public void persist(T entity) {
		em.persist(entity);
	}

	public T merge(T entity) {
		return em.merge(entity);
	}

	public void remove(T entity) {
		em.remove(entity);
	}

	public T find(ID primaryKey) {
		return em.find(entityClass, primaryKey);
	}

	public List<T> list() {
		return list(Collections.<Order> emptyList());
	}
	
	public List<T> list(Order order) {
		List<Order> orders = new ArrayList<Order>();
		orders.add(order);
		return list(orders);
	}
	
	public List<T> list(List<Order> orders) {
		criteriaQuery.select(root);
		if(orders!= null && orders.size() > 0) {
			this.criteriaQuery.orderBy(orders);
		}
		TypedQuery<T> typedQuery = em.createQuery(criteriaQuery);
		List<T> resultList = typedQuery.getResultList();
		return resultList;
	}

	public CriteriaBuilder getCriteriaBuilder() {
		return criteriaBuilder;
	}

	public CriteriaQuery<T> getCriteriaQuery() {
		return criteriaQuery;
	}

	public Root<T> getRoot() {
		return root;
	}

}
