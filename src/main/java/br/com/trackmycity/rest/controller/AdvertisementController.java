package br.com.trackmycity.rest.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.trackmycity.dao.AdvertisementDAO;
import br.com.trackmycity.interceptors.Transactional;
import br.com.trackmycity.models.Advertisement;

@Path("ad")
public class AdvertisementController {
	
	@Inject private AdvertisementDAO advertisementDAO;
	
	@GET @Path("{id}") @Produces(MediaType.APPLICATION_JSON)
	public Advertisement find(@PathParam("id") Long id) {
		Advertisement found = advertisementDAO.find(id);
		return found;
	}
	
	@Transactional
	@POST @Path("/") @Consumes(MediaType.APPLICATION_JSON) @Produces(MediaType.APPLICATION_JSON)
	public Advertisement create(Advertisement Advertisement) {
		Advertisement = advertisementDAO.merge(Advertisement);
		return Advertisement;
	}
	
	@GET @Path("/list") @Produces(MediaType.APPLICATION_JSON)
	public List<Advertisement> list() {
		List<Advertisement> list = advertisementDAO.list();
		return list;
	}
}
