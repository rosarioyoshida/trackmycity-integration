package br.com.trackmycity.rest.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import org.apache.commons.io.IOUtils;
import org.codehaus.jackson.map.annotate.JsonView;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
import org.slf4j.Logger;

import br.com.trackmycity.beans.google.GeoLocation;
import br.com.trackmycity.beans.google.GeocodeResponse;
import br.com.trackmycity.config.jackson.Views;
import br.com.trackmycity.dao.AlertTypeDAO;
import br.com.trackmycity.dao.UserAlertDAO;
import br.com.trackmycity.dao.UserDAO;
import br.com.trackmycity.helper.GoogleHelper;
import br.com.trackmycity.interceptors.Statistics;
import br.com.trackmycity.interceptors.Transactional;
import br.com.trackmycity.models.AlertType;
import br.com.trackmycity.models.User;
import br.com.trackmycity.models.UserAlert;
import br.com.trackmycity.models.embeddable.Location;
import br.com.trackmycity.producers.Log;
import br.com.trackmycity.rest.bean.CreateUserAlertForm;
import br.com.trackmycity.rest.bean.LocationTO;
import br.com.trackmycity.rest.bean.MediaType;
import br.com.trackmycity.utils.GoogleUtils;

@Path("alert")
public class UserAlertController {
	
	@Inject private UserAlertDAO userAlertDAO;
	@Inject private AlertTypeDAO alertTypeDAO;
	@Inject private UserDAO userDAO;
	@Inject private GoogleUtils googleUtils;
	@Inject private GoogleHelper googleHelper;
	@Context ServletContext servletContext;
	@Inject @Log private Logger logger;
	
	
	@GET @Path("{id}") @Produces(MediaType.APPLICATION_JSON_CHARSET_UTF8)
	@JsonView(Views.UserAlertDetail.class)
	public UserAlert find(@PathParam("id") Long id) {
		UserAlert found = userAlertDAO.findComplete(id);
		return found;
	}
	
	@Statistics
	@POST @Path("/listWithinDistance") @Consumes(MediaType.APPLICATION_JSON) @Produces(MediaType.APPLICATION_JSON_CHARSET_UTF8)
	@JsonView(Views.UserAlertsOnMap.class)
	public List<UserAlert> listWithinDistance(LocationTO locationTO) {
		logger.debug("buscando alertas para o mapa...");
		//log.debug("lat: ");
		GeoLocation location = GeoLocation.convertDegreesToRadians(locationTO.getLat(), locationTO.getLng());
		GeoLocation[] boundingCoordinates = location.boundingCoordinates(locationTO.getDistance());
		List<UserAlert> list = userAlertDAO.listWithinDistance(location, boundingCoordinates, locationTO.getDistance());
		return list;
	}
	
	@Transactional
	@POST @Path("/") @Consumes(MediaType.MULTIPART_FORM_DATA) @Produces(MediaType.APPLICATION_JSON_CHARSET_UTF8)
	@JsonView(Views.UserAlertDetail.class)
	public UserAlert create(@MultipartForm CreateUserAlertForm form) throws IOException {
		logger.debug("gravando user alert...");
		logger.debug("desciption: {}", form.getDescription());
		logger.debug("lat: {}", form.getLat());
		logger.debug("lng: {}", form.getLng());
		logger.debug("alertTypeId: {}", form.getAlertTypeId());
		logger.debug("photo: {}", form.getPhoto()==null?0:form.getPhoto().length);
		logger.debug("user email: {}", form.getEmail());
		
		User user = userDAO.findByEmail(form.getEmail());
		
		UserAlert userAlert = new UserAlert();
		userAlert.setDescription(form.getDescription());
		Location location = new Location(form.getLat(), form.getLng());
		GeoLocation degreesToRadians = GeoLocation.convertDegreesToRadians(Double.parseDouble(location.getLat()), Double.parseDouble(location.getLng()));
		location.setLatRadian(String.valueOf(degreesToRadians.getLatitudeInRadians()));
		location.setLngRadian(String.valueOf(degreesToRadians.getLongitudeInRadians()));
		userAlert.setLocation(location);
		userAlert.setPhoto(form.getPhoto());
		userAlert.setUser(user);
		
		AlertType alertType = alertTypeDAO.find(form.getAlertTypeId());
		
		userAlert.setAlertType(alertType);
		
		GeocodeResponse geocodeResponse = googleUtils.getAddressComponents(Double.parseDouble(userAlert.getLocation().getLat()), Double.parseDouble(userAlert.getLocation().getLng()));
		
		userAlert.setRoute(googleHelper.getRoute(geocodeResponse.getResults()));
		userAlert.setStreetNumber(googleHelper.getStreetNumber());
		userAlert.setFormattedAddress(userAlert.getRoute().getShortName()+", "+googleHelper.getStreetNumber()+" - "+userAlert.getRoute().getSublocality().getShortName()+", "+userAlert.getRoute().getSublocality().getLocality().getShortName());
		
		userAlert = userAlertDAO.merge(userAlert);
		logger.debug("user alert gravado com sucesso...");
		return userAlert;
	}

	@GET @Path("{id}/photo.jpeg") @Produces(MediaType.MEDIA_TYPE_IMAGE_JPEG)
	public byte[] getPhoto(@PathParam("id") Long id) throws IOException {
		byte[] photo = null;
		photo = userAlertDAO.findPhoto(id);
		if(photo == null || photo.length == 0) {
			InputStream in = servletContext.getResourceAsStream("images/no_photo_available.jpg");
			photo = IOUtils.toByteArray(in);
		}
		return photo;
	}

}
