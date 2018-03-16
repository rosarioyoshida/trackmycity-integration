package br.com.trackmycity.services.impl;

import javax.inject.Inject;
import javax.persistence.NoResultException;

import br.com.trackmycity.dao.UserDAO;
import br.com.trackmycity.exceptions.UserEmailFoundException;
import br.com.trackmycity.exceptions.UserNotFoundException;
import br.com.trackmycity.exceptions.UserException;
import br.com.trackmycity.interceptors.Transactional;
import br.com.trackmycity.models.User;
import br.com.trackmycity.rest.controller.UserResponse;
import br.com.trackmycity.services.UserService;

public class UserServiceImpl implements UserService {
	
	@Inject
	private UserDAO userDAO;
	
	
	@Transactional
	@Override
	public User register(User user) throws UserException, UserEmailFoundException {
		
		User userFound = null;
		try{
			//OBTEM USER POR EMAIL
			userFound = userDAO.findByEmail(user.getEmail());
			
		}catch(NoResultException e){
			
			//CASO NAO EXISTIR DEVERA SER INSERIDO UM NOVO
			try{
				this.insertUser(user);
			}catch(Exception ex){
				throw new UserException();
			}
			
		}catch (Exception e) {
			throw new UserException();
		}
		
		//VALIDA SE O EMAIL JA EXISTE NA BASE DE DADOS
		if (userFound != null){
			throw new UserEmailFoundException();
		}

		return user;
	}
	
	@Transactional
	private User insertUser(User user){
		userDAO.merge(user);
		return user;
	}

	@Override
	public User getUser(User user) throws UserException,UserNotFoundException {
		User userFound = null;
		try{
			userFound = userDAO.find(user);
		}catch (NoResultException e) {
			throw new UserNotFoundException(UserResponse.RETURN_CODE_ERROR, UserResponse.RETURN_MESSAGE_ERROR);
		}catch(Exception e){
			throw new UserException(UserResponse.RETURN_CODE_ERROR, UserResponse.RETURN_MESSAGE_ERROR);
		}
		return userFound;
	}
	

}
