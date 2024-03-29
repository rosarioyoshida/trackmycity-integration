package br.com.trackmycity.interceptors;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

import org.slf4j.Logger;

import br.com.trackmycity.producers.Log;

@Transactional @Interceptor
public class TransactionalInterceptor {
	
	@Inject	private EntityManager em;
	@Inject @Log private Logger logger;

	@AroundInvoke
	public Object intercept(InvocationContext ctx) throws Exception {
		logger.debug("Abrindo a transacao");
		this.em.getTransaction().begin();

		Object result = ctx.proceed();

		this.em.getTransaction().commit();
		logger.debug("Comitando a transacao");

		return result;
	}
}
