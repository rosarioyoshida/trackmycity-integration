package br.com.trackmycity.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.Root;

import br.com.trackmycity.models.AdmLevelOne;

public class AdmLevelOneDAO extends GenericDAO {

	private static final long serialVersionUID = -188029030140924320L;
	private CommonOperationsDAO<AdmLevelOne, Long> commonDAO;

	@Inject
	public AdmLevelOneDAO(EntityManager em) {
		super(em); 
		this.commonDAO = new CommonOperationsDAO<AdmLevelOne, Long>(em, AdmLevelOne.class);
	}

	public void persist(AdmLevelOne entity) {
		commonDAO.persist(entity);
	}

	public AdmLevelOne findByName(String name) {
		Root<AdmLevelOne> root = commonDAO.getRoot();
		commonDAO.getCriteriaQuery().select(root).where(commonDAO.getCriteriaBuilder().equal(root.get("shortName"), name));
		TypedQuery<AdmLevelOne> query = em.createQuery(commonDAO.getCriteriaQuery());
		query.setHint("org.hibernate.cacheable", true);
		return query.getSingleResult();
	}
	
}
