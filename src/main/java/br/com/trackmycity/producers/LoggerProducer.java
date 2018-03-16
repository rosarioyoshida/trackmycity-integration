package br.com.trackmycity.producers;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class LoggerProducer {
	
	@Produces @Log
	public static Logger getLogger(final InjectionPoint ip){
		return LoggerFactory.getLogger(ip.getMember().getDeclaringClass());
	}
	
}
