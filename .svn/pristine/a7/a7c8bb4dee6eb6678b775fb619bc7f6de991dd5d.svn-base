package br.com.trackmycity.services;

import br.com.trackmycity.exceptions.UserEmailFoundException;
import br.com.trackmycity.exceptions.UserNotFoundException;
import br.com.trackmycity.exceptions.UserException;
import br.com.trackmycity.models.User;

public interface UserService {
	
	public User register(User user) throws UserEmailFoundException, UserException;
	
	public User getUser(User user) throws UserException, UserNotFoundException;
}
