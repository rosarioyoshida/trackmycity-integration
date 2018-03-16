package br.com.trackmycity.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.Root;

import br.com.trackmycity.models.Country;

public class CountryDAO extends GenericDAO {

	private static final long serialVersionUID = 2472651481764865944L;
	private CommonOperationsDAO<Country, Long> commonDAO;

	@Inject
	public CountryDAO(EntityManager em) {
		super(em); 
		this.commonDAO = new CommonOperationsDAO<Country, Long>(em, Country.class);
	}

	public void persist(Country entity) {
		commonDAO.persist(entity);
	}

	public Country findByName(String name) {
		Root<Country> root = commonDAO.getRoot();
		commonDAO.getCriteriaQuery().select(root).where(commonDAO.getCriteriaBuilder().equal(root.get("shortName"), name));
		TypedQuery<Country> query = em.createQuery(commonDAO.getCriteriaQuery());
		query.setHint("org.hibernate.cacheable", true);
		return query.getSingleResult();
	}
	
}
