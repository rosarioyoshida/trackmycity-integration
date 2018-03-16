package br.com.trackmycity.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.Root;

import br.com.trackmycity.models.Locality;

public class LocalityDAO extends GenericDAO {

	private static final long serialVersionUID = 2526677362429985030L;
	private CommonOperationsDAO<Locality, Long> commonDAO;

	@Inject
	public LocalityDAO(EntityManager em) {
		super(em); 
		this.commonDAO = new CommonOperationsDAO<Locality, Long>(em, Locality.class);
	}

	public void persist(Locality entity) {
		commonDAO.persist(entity);
	}

	public Locality findByName(String name) {
		Root<Locality> root = commonDAO.getRoot();
		commonDAO.getCriteriaQuery().select(root).where(commonDAO.getCriteriaBuilder().equal(root.get("shortName"), name));
		TypedQuery<Locality> query = em.createQuery(commonDAO.getCriteriaQuery());
		query.setHint("org.hibernate.cacheable", true);
		return query.getSingleResult();
	}
	
}
