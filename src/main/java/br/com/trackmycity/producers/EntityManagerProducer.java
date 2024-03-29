package br.com.trackmycity.producers;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProducer {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("trackmycity");
	
	@Produces @RequestScoped
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public void disposeEntityManager(@Disposes EntityManager em) {
		em.close();
	}
	
}
