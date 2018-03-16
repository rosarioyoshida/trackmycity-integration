package br.com.trackmycity.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import br.com.trackmycity.models.AlertType;

public class AlertTypeDAO extends GenericDAO {
	
	private static final long serialVersionUID = 5043438520095163284L;
	private CommonOperationsDAO<AlertType, Long> commonDAO;

	@Inject
	public AlertTypeDAO(EntityManager em) {
		super(em);
		this.commonDAO = new CommonOperationsDAO<AlertType, Long>(em, AlertType.class);
	}

	public void persist(AlertType entity) {
		commonDAO.persist(entity);
	}

	public AlertType merge(AlertType entity) {
		return commonDAO.merge(entity);
	}

	public void remove(AlertType entity) {
		commonDAO.remove(entity);
	}

	public AlertType find(Long primaryKey) {
		return commonDAO.find(primaryKey);
	}

	public List<AlertType> list() {
		return commonDAO.list();
	}

	public List<AlertType> list(List<Order> orders) {
		return commonDAO.list(orders);
	}

	public CriteriaBuilder getCriteriaBuilder() {
		return commonDAO.getCriteriaBuilder();
	}

	public CriteriaQuery<AlertType> getCriteriaQuery() {
		return commonDAO.getCriteriaQuery();
	}

	public Root<AlertType> getRoot() {
		return commonDAO.getRoot();
	}
	
	

}
