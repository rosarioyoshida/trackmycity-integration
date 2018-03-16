package br.com.trackmycity.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.trackmycity.models.User;

public class UserDAO extends GenericDAO {
	
	private static final long serialVersionUID = -1661080446943617317L;
	private CommonOperationsDAO<User, Long> commonDAO;

	@Inject
	public UserDAO(EntityManager em) {
		super(em); 
		this.commonDAO = new CommonOperationsDAO<User, Long>(em, User.class);
	}

	public void persist(User entity) {
		commonDAO.persist(entity);
	}

	public User merge(User entity) {
		return commonDAO.merge(entity);
	}

	public User find(Long primaryKey) {
		return commonDAO.find(primaryKey);
	}

	public User findByEmail(String email) {
		getCriteriaQuery().select(getRoot()).where(getCriteriaBuilder().equal(getRoot().get("email"), email));
		TypedQuery<User> query = em.createQuery(getCriteriaQuery());
		User user = query.getSingleResult();
		return user;
	}
	
	public CriteriaBuilder getCriteriaBuilder() {
		return commonDAO.getCriteriaBuilder();
	}

	public CriteriaQuery<User> getCriteriaQuery() {
		return commonDAO.getCriteriaQuery();
	}

	public Root<User> getRoot() {
		return commonDAO.getRoot();
	}
	
	public User find(User user) {
		
		Predicate predicate = getCriteriaBuilder()
				.and(getCriteriaBuilder().equal(getRoot().get("email"), user.getEmail()), 
						getCriteriaBuilder().equal(getRoot().get("password"), user.getPassword()));
		
		getCriteriaQuery().select(getRoot())
			.where(predicate);
			
		TypedQuery<User> query = em.createQuery(getCriteriaQuery());
		User userFound = query.getSingleResult();
		return userFound;
	}
}
