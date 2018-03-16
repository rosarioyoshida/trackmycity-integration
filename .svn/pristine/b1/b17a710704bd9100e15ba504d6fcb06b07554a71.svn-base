package br.com.trackmycity.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import br.com.trackmycity.beans.google.GeoLocation;
import br.com.trackmycity.models.UserAlert;

public class UserAlertDAO extends GenericDAO {
	
	private static final long serialVersionUID = 7539908411715921073L;
	private CommonOperationsDAO<UserAlert, Long> commonDAO;

	@Inject
	public UserAlertDAO(EntityManager em) {
		super(em); 
		this.commonDAO = new CommonOperationsDAO<UserAlert, Long>(em, UserAlert.class);
	}

	public void persist(UserAlert entity) {
		commonDAO.persist(entity);
	}

	public UserAlert merge(UserAlert entity) {
		return commonDAO.merge(entity);
	}

	public UserAlert find(Long primaryKey) {
		return commonDAO.find(primaryKey);
	}
	
	public List<UserAlert> listWithinDistance(GeoLocation location, GeoLocation[] boundingCoordinates, Double distance) {
		boolean meridian180WithinDistance = boundingCoordinates[0].getLongitudeInRadians() > boundingCoordinates[1].getLongitudeInRadians();
		
		String sql = "SELECT ua.*, at.* FROM USER_ALERT ua" +
				" INNER JOIN ALERT_TYPE at ON ua.alert_type_id = at.id" +	
				" WHERE (lat_radian >= ? AND lat_radian <= ?) AND (lng_radian >= ? " +
				(meridian180WithinDistance ? "OR" : "AND") + " lng_radian <= ?) AND " +
				"acos(sin(?) * sin(lat_radian) + cos(?) * cos(lat_radian) * cos(lng_radian - ?)) <= ?"; 
		@SuppressWarnings("unchecked")
		TypedQuery<UserAlert> createNativeQuery = (TypedQuery<UserAlert>) em.createNativeQuery(sql, UserAlert.class);
		createNativeQuery.setParameter(1, boundingCoordinates[0].getLatitudeInRadians());
		createNativeQuery.setParameter(2, boundingCoordinates[1].getLatitudeInRadians());
		createNativeQuery.setParameter(3, boundingCoordinates[0].getLongitudeInRadians());
		createNativeQuery.setParameter(4, boundingCoordinates[1].getLongitudeInRadians());
		createNativeQuery.setParameter(5, location.getLatitudeInRadians());
		createNativeQuery.setParameter(6, location.getLatitudeInRadians());
		createNativeQuery.setParameter(7, location.getLongitudeInRadians());
		createNativeQuery.setParameter(8, location.getRadDist());
		createNativeQuery.setHint("org.hibernate.cacheable", true);
		List<UserAlert> resultList = createNativeQuery.getResultList();
		return resultList;
	}
	
	public UserAlert findComplete(Long primaryKey) {
		Root<UserAlert> root = commonDAO.getRoot();
		root.fetch("route").fetch("sublocality").fetch("locality").fetch("admLevelOne").fetch("country");
		root.fetch("alertType").fetch("alertGroupType");
		getCriteriaQuery().select(root).where(getCriteriaBuilder().equal(root.get("id"), primaryKey));
		TypedQuery<UserAlert> query = em.createQuery(getCriteriaQuery());
		query.setHint("org.hibernate.cacheable", true);
		return query.getSingleResult();
	}
	
	public byte[] findPhoto(Long primaryKey) {
		getCriteriaQuery().multiselect(getRoot().get("photo")).where(getCriteriaBuilder().equal(getRoot().get("id"), primaryKey));
		TypedQuery<UserAlert> query = em.createQuery(getCriteriaQuery());
		query.setHint("org.hibernate.cacheable", true);
		UserAlert ua = query.getSingleResult();
		return (byte[]) ua.getPhoto();
	}
	
	public List<UserAlert> list() {
		return commonDAO.list();
	}

	public List<UserAlert> list(Order order) {
		return commonDAO.list(order);
	}
	
	public List<UserAlert> list(List<Order> orders) {
		return commonDAO.list(orders);
	}

	public CriteriaBuilder getCriteriaBuilder() {
		return commonDAO.getCriteriaBuilder();
	}

	public CriteriaQuery<UserAlert> getCriteriaQuery() {
		return commonDAO.getCriteriaQuery();
	}

	public Root<UserAlert> getRoot() {
		return commonDAO.getRoot();
	}
	
}
