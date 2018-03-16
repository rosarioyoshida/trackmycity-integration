package br.com.trackmycity.interceptors;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.stat.Statistics;
import org.slf4j.Logger;

import br.com.trackmycity.producers.Log;

@br.com.trackmycity.interceptors.Statistics @Interceptor
public class StatisticsInterceptor {
	
	@Inject	private EntityManager em;
	@Inject @Log private Logger logger;

	@AroundInvoke
	public Object intercept(InvocationContext ctx) throws Exception {
		logger.debug("Abrindo a transacao");

		Object result = ctx.proceed();

		logger.debug("Comitando a transacao");

		Session session = (Session)em.getDelegate();
		Statistics statistics = session.getSessionFactory().getStatistics();
		statistics.setStatisticsEnabled(true);
		System.out.println("SecondLevelCacheHitCount: " + statistics.getSecondLevelCacheHitCount());
		System.out.println("SecondLevelCacheMissCount: " + statistics.getSecondLevelCacheMissCount());
		System.out.println("SecondLevelCachePutCount: " + statistics.getSecondLevelCachePutCount());
		System.out.println("SecondLevelCacheRegionNames: " + statistics.getSecondLevelCacheRegionNames());
		
		
		return result;
	}
}
