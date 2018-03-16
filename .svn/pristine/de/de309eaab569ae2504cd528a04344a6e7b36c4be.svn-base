package br.com.trackmycity.rest.controller;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.codehaus.jackson.map.annotate.JsonView;
import org.slf4j.Logger;

import br.com.trackmycity.config.jackson.Views;
import br.com.trackmycity.exceptions.UserEmailFoundException;
import br.com.trackmycity.exceptions.UserException;
import br.com.trackmycity.models.User;
import br.com.trackmycity.producers.Log;
import br.com.trackmycity.rest.bean.MediaType;
import br.com.trackmycity.services.UserService;

@Path("user")
public class UserController {
	
	@Inject 
	private UserService userService;
	
	@Inject 
	@Log 
	private Logger logger;
	
	@POST 
	@Path("/") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.APPLICATION_JSON_CHARSET_UTF8)
	@JsonView(Views.UserAlertDetail.class)
	public UserResponse register(User newUser) {
		logger.debug("Inicio metodo register");
		
		UserResponse userResponse = null;
		User user = null;
		try {
			user = userService.register(newUser);
			userResponse = new UserResponse(user, UserResponse.RETURN_CODE_SUCCESS, UserResponse.RETURN_MESSAGE_SUCCESS);
		} catch (UserEmailFoundException e) {
			userResponse = new UserResponse(newUser, UserResponse.RETURN_CODE_EMAIL_EXISTS, UserResponse.RETURN_MESSAGE_EMAIL_EXISTS);
		} catch (UserException e) {
			userResponse = new UserResponse(user, UserResponse.RETURN_CODE_ERROR, UserResponse.RETURN_MESSAGE_ERROR);
		}catch (Exception e) {
			userResponse = new UserResponse(user, UserResponse.RETURN_CODE_ERROR, UserResponse.RETURN_MESSAGE_ERROR);
		}
		logger.debug("Fim metodo register");
		return userResponse;
	}
	
	@POST
	@Path("/autenticate")
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.APPLICATION_JSON_CHARSET_UTF8)
	@JsonView(Views.UserAlertDetail.class)
	public UserResponse autenticate(User user){
		UserResponse userResponse = null;
		try{
			user = userService.getUser(user);
			userResponse = new UserResponse(user, UserResponse.RETURN_CODE_SUCCESS, UserResponse.RETURN_MESSAGE_SUCCESS);
		}catch(Exception e){
			userResponse = new UserResponse(user, UserResponse.RETURN_CODE_ERROR, UserResponse.RETURN_MESSAGE_ERROR);
		}
		return userResponse;
	}

}
