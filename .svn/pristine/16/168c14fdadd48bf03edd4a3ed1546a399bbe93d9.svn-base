package br.com.trackmycity.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import br.com.trackmycity.models.Advertisement;

public class AdvertisementDAO extends GenericDAO {
	
	private static final long serialVersionUID = 7539908411715921073L;
	private CommonOperationsDAO<Advertisement, Long> commonDAO;

	@Inject
	public AdvertisementDAO(EntityManager em) {
		super(em); 
		this.commonDAO = new CommonOperationsDAO<Advertisement, Long>(em, Advertisement.class);
	}

	public void persist(Advertisement entity) {
		commonDAO.persist(entity);
	}

	public Advertisement merge(Advertisement entity) {
		return commonDAO.merge(entity);
	}

	public Advertisement find(Long primaryKey) {
		return commonDAO.find(primaryKey);
	}

	public List<Advertisement> list() {
		return commonDAO.list();
	}

	public List<Advertisement> list(List<Order> orders) {
		return commonDAO.list(orders);
	}

	public CriteriaBuilder getCriteriaBuilder() {
		return commonDAO.getCriteriaBuilder();
	}

	public CriteriaQuery<Advertisement> getCriteriaQuery() {
		return commonDAO.getCriteriaQuery();
	}

	public Root<Advertisement> getRoot() {
		return commonDAO.getRoot();
	}
	
	
}
