package br.com.trackmycity.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import br.com.trackmycity.models.AlertGroupType;

public class AlertGroupTypeDAO extends GenericDAO {
	
	private static final long serialVersionUID = 8135802877894497901L;
	private CommonOperationsDAO<AlertGroupType, Long> commonDAO;

	@Inject
	public AlertGroupTypeDAO(EntityManager em) {
		super(em);
		this.commonDAO = new CommonOperationsDAO<AlertGroupType, Long>(em, AlertGroupType.class);
	}

	public void persist(AlertGroupType entity) {
		commonDAO.persist(entity);
	}

	public AlertGroupType merge(AlertGroupType entity) {
		return commonDAO.merge(entity);
	}

	public void remove(AlertGroupType entity) {
		commonDAO.remove(entity);
	}

	public AlertGroupType find(Long primaryKey) {
		return commonDAO.find(primaryKey);
	}

	public List<AlertGroupType> list() {
		return commonDAO.list();
	}

	public List<AlertGroupType> list(List<Order> orders) {
		return commonDAO.list(orders);
	}

	public CriteriaBuilder getCriteriaBuilder() {
		return commonDAO.getCriteriaBuilder();
	}

	public CriteriaQuery<AlertGroupType> getCriteriaQuery() {
		return commonDAO.getCriteriaQuery();
	}

	public Root<AlertGroupType> getRoot() {
		return commonDAO.getRoot();
	}

}
