package br.com.trackmycity.producers;

import java.util.Set;

import javax.inject.Inject;
import javax.validation.Validator;
import javax.validation.ConstraintViolation;

public class BeanValidator {
	
	@Inject private Validator validator;
	
	public <T> Set<ConstraintViolation<T>> validate(T t){
		return validator.validate(t);
	}
}
