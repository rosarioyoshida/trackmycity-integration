package br.com.trackmycity.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.Root;

import br.com.trackmycity.models.Sublocality;

public class SublocalityDAO extends GenericDAO {

	private static final long serialVersionUID = 2526677362429985030L;
	private CommonOperationsDAO<Sublocality, Long> commonDAO;

	@Inject
	public SublocalityDAO(EntityManager em) {
		super(em); 
		this.commonDAO = new CommonOperationsDAO<Sublocality, Long>(em, Sublocality.class);
	}

	public void persist(Sublocality entity) {
		commonDAO.persist(entity);
	}

	public Sublocality findByName(String name) {
		Root<Sublocality> root = commonDAO.getRoot();
		commonDAO.getCriteriaQuery().select(root).where(commonDAO.getCriteriaBuilder().equal(root.get("shortName"), name));
		TypedQuery<Sublocality> query = em.createQuery(commonDAO.getCriteriaQuery());
		query.setHint("org.hibernate.cacheable", true);
		return query.getSingleResult();
	}
	
}
