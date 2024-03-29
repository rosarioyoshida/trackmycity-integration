package br.com.trackmycity.rest.controller;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.trackmycity.dao.AlertGroupTypeDAO;
import br.com.trackmycity.dao.UserAlertDAO;
import br.com.trackmycity.interceptors.Transactional;
import br.com.trackmycity.models.AlertGroupType;
import br.com.trackmycity.models.UserAlert;

@Path("/teste")
public class TesteResteasy {

	@Inject private AlertGroupTypeDAO alertGroupTypeDAO;
	@Inject private UserAlertDAO userAlertDAO;
	@Inject private EntityManager em;
	
	@GET @Path("/hello") @Produces(MediaType.APPLICATION_JSON)
	public AlertGroupType hello() {
		return alertGroupTypeDAO.find(1l);
	}

	@GET @Path("/list") @Produces(MediaType.APPLICATION_JSON)
	public List<AlertGroupType> list() {
		return alertGroupTypeDAO.list(Arrays.asList(alertGroupTypeDAO.getCriteriaBuilder().asc(alertGroupTypeDAO.getRoot().get("name"))));
	}

	@GET @Path("/listAlerts") @Produces(MediaType.APPLICATION_JSON)
	public List<UserAlert> listAlerts() {
		List<UserAlert> list = userAlertDAO.list(Arrays.asList(userAlertDAO.getCriteriaBuilder().asc(userAlertDAO.getRoot().get("id"))));;
		return list;
	}
	

	@Transactional
	@POST @Path("/") @Consumes(MediaType.APPLICATION_JSON) @Produces(MediaType.APPLICATION_JSON)
	public UserAlert save(UserAlert userAlert) {
		userAlert = em.merge(userAlert);
		//userAlertDAO.merge(userAlert);
		return userAlert;
	}
	
}
