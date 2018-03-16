package br.com.trackmycity.servlet;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.trackmycity.models.AlertGroupType;
import br.com.trackmycity.models.AlertType;
import br.com.trackmycity.models.SocialNetworkType;
import br.com.trackmycity.models.User;
import br.com.trackmycity.utils.GoogleUtils;

public class InitializeDataBase extends HttpServlet {

	private static final long serialVersionUID = 3248532085699862303L;
	public static final String GROUP_TYPE_NAME = "Grupo Genérico"; 
	public static final String FLOOD_ALERT_TYPE_NAME = "Alagamento"; 
	public static final String MOSQUITO_ALERT_TYPE_NAME = "Foco de Dengue"; 
	public static final String NO_LIGHT_ALERT_TYPE_NAME = "Sem Iluminação Pública"; 
	public static final String STREET_HOLE_ALERT_TYPE_NAME = "Rua/Avenida Esburacada"; 
	public static final String TRAFFIC_LIGHT_ALERT_TYPE_NAME = "Semáforo com Defeito"; 
	public static final String TRASH_ALERT_TYPE_NAME = "Lixo Espalhado"; 

	@Inject GoogleUtils googleUtils;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try{
			initDatabase();
			req.getServletContext().getRequestDispatcher("/initResult.jsp").forward(req, resp);
		}catch(URISyntaxException e){
			throw new ServletException(e);
		}
	}
	
	public static void initDatabase() throws URISyntaxException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("trackmycity");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		AlertGroupType group = new AlertGroupType();
		group.setName(GROUP_TYPE_NAME);
		
		AlertType type = new AlertType();
		type.setName(FLOOD_ALERT_TYPE_NAME);
		type.setIconMap("/images/icons/map/flood_map_icon_75.png");
		type.setAlertGroupType(group);
		em.persist(type);

		type = new AlertType();
		type.setName(MOSQUITO_ALERT_TYPE_NAME);
		type.setIconMap("/images/icons/map/mosquito_map_icon_75.png");
		type.setAlertGroupType(group);
		em.persist(type);

		type = new AlertType();
		type.setName(NO_LIGHT_ALERT_TYPE_NAME);
		type.setIconMap("/images/icons/map/no_light_map_icon_75.png");
		type.setAlertGroupType(group);
		em.persist(type);

		type = new AlertType();
		type.setName(STREET_HOLE_ALERT_TYPE_NAME);
		type.setIconMap("/images/icons/map/street_hole_map_icon_75.png");
		type.setAlertGroupType(group);
		em.persist(type);

		type = new AlertType();
		type.setName(TRAFFIC_LIGHT_ALERT_TYPE_NAME);
		type.setIconMap("/images/icons/map/traffic_light_map_icon_75.png");
		type.setAlertGroupType(group);
		em.persist(type);

		type = new AlertType();
		type.setName(TRASH_ALERT_TYPE_NAME);
		type.setIconMap("/images/icons/map/trash_map_icon_75.png");
		type.setAlertGroupType(group);
		em.persist(type);
		
		SocialNetworkType socialType1 = new SocialNetworkType();
		socialType1.setName("REGULAR");

		SocialNetworkType socialType2 = new SocialNetworkType();
		socialType2.setName("FACEBOOK");

		SocialNetworkType socialType3 = new SocialNetworkType();
		socialType3.setName("GOOGLE+");

		socialType1 = em.merge(socialType1);
		em.persist(socialType2);
		em.persist(socialType3);
		
		User user1 = new User();
		user1.setEmail("rosario.yoshida@gmail.com");
		user1.setName("Rosário Yoshida");
		user1.setPassword("teste");
		user1.setSocialNetworkType(socialType1);

		User user2 = new User();
		user2.setEmail("rolives@gmail.com");
		user2.setName("Rogério de Lima");
		user2.setPassword("teste");
		user2.setSocialNetworkType(socialType1);

		em.persist(user1);
		em.persist(user2);
		
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	
}

