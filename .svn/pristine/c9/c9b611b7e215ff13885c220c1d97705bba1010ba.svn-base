package br.com.trackmycity.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.Root;

import br.com.trackmycity.models.Route;

public class RouteDAO extends GenericDAO {

	private static final long serialVersionUID = 2526677362429985030L;
	private CommonOperationsDAO<Route, Long> commonDAO;

	@Inject
	public RouteDAO(EntityManager em) {
		super(em); 
		this.commonDAO = new CommonOperationsDAO<Route, Long>(em, Route.class);
	}

	public void persist(Route entity) {
		commonDAO.persist(entity);
	}

	public Route findByName(String name) {
		Root<Route> root = commonDAO.getRoot();
		commonDAO.getCriteriaQuery().select(root).where(commonDAO.getCriteriaBuilder().equal(root.get("shortName"), name));
		TypedQuery<Route> query = em.createQuery(commonDAO.getCriteriaQuery());
		query.setHint("org.hibernate.cacheable", true);
		return query.getSingleResult();
	}
	
}
