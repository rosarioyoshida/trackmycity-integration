package br.com.trackmycity.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;

import br.com.trackmycity.beans.google.AddressComponent;
import br.com.trackmycity.beans.google.GeoLocation;
import br.com.trackmycity.beans.google.GeocodeResponse;
import br.com.trackmycity.beans.google.Result;
import br.com.trackmycity.enumerations.FormatEnum;
import br.com.trackmycity.enumerations.MapsTypeEnum;
import br.com.trackmycity.models.AdmLevelOne;
import br.com.trackmycity.models.AlertGroupType;
import br.com.trackmycity.models.AlertType;
import br.com.trackmycity.models.Country;
import br.com.trackmycity.models.Locality;
import br.com.trackmycity.models.Route;
import br.com.trackmycity.models.Sublocality;
import br.com.trackmycity.models.UserAlert;
import br.com.trackmycity.models.embeddable.Location;
import br.com.trackmycity.utils.GoogleUtils;



public class SaveGeoLocation extends HttpServlet {

	private static final long serialVersionUID = 3248532085699862303L;
	private static final String DEFAULT_SUBLOCALITY_NAME = "Sem Bairro";
	
	
	@Inject GoogleUtils googleUtils;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		double lat = Double.parseDouble(req.getParameter("lat"));
		double lng = Double.parseDouble(req.getParameter("lng"));
		save(lat, lng);
		req.getServletContext().getRequestDispatcher("/saveGeoLocationResult.jsp").forward(req, resp);
	}

	public void save(double lat, double lng) {
		try{
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("trackmycity");
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			//***************************************************************
			
			AlertGroupType group = em.createQuery("from AlertGroupType ag where ag.name=:name", AlertGroupType.class).setParameter("name", InitializeDataBase.GROUP_TYPE_NAME).getSingleResult();
			List<AlertType> alertTypes = em.createQuery("from AlertType at", AlertType.class).getResultList();
			
			JAXBContext ctx = JAXBContext.newInstance(GeocodeResponse.class);
			Unmarshaller unmarshaller = ctx.createUnmarshaller();
			GeocodeResponse response = (GeocodeResponse)unmarshaller.unmarshal(googleUtils.loadGeoLocation(lat, lng, FormatEnum.XML));
			
			Result result = response.getResults().get(0);
			
			List resultList = new ArrayList();
			CollectionUtils.select(result.getAddressComponents(), new Predicate(){
	
				@Override
				public boolean evaluate(Object o) {
					AddressComponent ac = (AddressComponent)o;
					for (MapsTypeEnum type : ac.getTypes()) {
						if(type.equals(MapsTypeEnum.route)){
							return true;
						}
					}
					return false;
				}
				
			}, resultList);
			
			AddressComponent ac = (AddressComponent)resultList.get(0);
	
			Route route = null;
			try{
				route = em.createQuery("from Route r where r.longName=:name", Route.class).setParameter("name", ac.getLongName()).getSingleResult();
			}catch(NoResultException e){
				route = new Route();
				route.setShortName(ac.getShortName());
				route.setLongName(ac.getLongName());
			}
			
			resultList = new ArrayList();
			CollectionUtils.select(result.getAddressComponents(), new Predicate(){
				
				@Override
				public boolean evaluate(Object o) {
					AddressComponent ac = (AddressComponent)o;
					for (MapsTypeEnum type : ac.getTypes()) {
						if(type.equals(MapsTypeEnum.street_number)){
							return true;
						}
					}
					return false;
				}
				
			}, resultList);
			
			AddressComponent streetNumber = new AddressComponent();
			if(!resultList.isEmpty()) {
				streetNumber = (AddressComponent)resultList.get(0);
			}
			
			
			resultList = new ArrayList();
			CollectionUtils.select(result.getAddressComponents(), new Predicate(){
	
				@Override
				public boolean evaluate(Object o) {
					AddressComponent ac = (AddressComponent)o;
					for (MapsTypeEnum type : ac.getTypes()) {
						if(type.equals(MapsTypeEnum.sublocality)){
							return true;
						}
					}
					return false;
				}
				
			}, resultList);
			
			Sublocality sublocality = null;
			try{
				ac = (AddressComponent)resultList.get(0);
				try{
					sublocality = em.createQuery("from Sublocality s where s.longName=:name", Sublocality.class).setParameter("name", ac.getLongName()).getSingleResult();
				}catch(NoResultException e){
					sublocality = new Sublocality();
					sublocality.setShortName(ac.getShortName());
					sublocality.setLongName(ac.getLongName());
				}
			}catch(IndexOutOfBoundsException e){
				sublocality = new Sublocality();
				sublocality.setShortName(DEFAULT_SUBLOCALITY_NAME);
				sublocality.setLongName(DEFAULT_SUBLOCALITY_NAME);
			}
			route.setSublocality(sublocality);
			
			
			resultList = new ArrayList();
			CollectionUtils.select(result.getAddressComponents(), new Predicate(){
	
				@Override
				public boolean evaluate(Object o) {
					AddressComponent ac = (AddressComponent)o;
					for (MapsTypeEnum type : ac.getTypes()) {
						if(type.equals(MapsTypeEnum.locality)){
							return true;
						}
					}
					return false;
				}
				
			}, resultList);
			
			ac = (AddressComponent)resultList.get(0);
			
			Locality locality = null;
			try{
				locality = em.createQuery("from Locality l where l.longName=:name", Locality.class).setParameter("name", ac.getLongName()).getSingleResult();
			}catch(NoResultException e){
				locality = new Locality();
				locality.setShortName(ac.getShortName());
				locality.setLongName(ac.getLongName());
			}
			sublocality.setLocality(locality);
			
			
			resultList = new ArrayList();
			CollectionUtils.select(result.getAddressComponents(), new Predicate(){
	
				@Override
				public boolean evaluate(Object o) {
					AddressComponent ac = (AddressComponent)o;
					for (MapsTypeEnum type : ac.getTypes()) {
						if(type.equals(MapsTypeEnum.administrative_area_level_1)){
							return true;
						}
					}
					return false;
				}
				
			}, resultList);
			
			ac = (AddressComponent)resultList.get(0);
			
			AdmLevelOne admLevelOne = null;
			try{
				admLevelOne = em.createQuery("from AdmLevelOne alo where alo.longName=:name", AdmLevelOne.class).setParameter("name", ac.getLongName()).getSingleResult();
			}catch(NoResultException e){
				admLevelOne = new AdmLevelOne();
				admLevelOne.setLongName(ac.getLongName());
				admLevelOne.setShortName(ac.getShortName());
			}
			locality.setAdmLevelOne(admLevelOne);
			
			
			resultList = new ArrayList();
			CollectionUtils.select(result.getAddressComponents(), new Predicate(){
				
				@Override
				public boolean evaluate(Object o) {
					AddressComponent ac = (AddressComponent)o;
					for (MapsTypeEnum type : ac.getTypes()) {
						if(type.equals(MapsTypeEnum.country)){
							return true;
						}
					}
					return false;
				}
				
			}, resultList);
			
			ac = (AddressComponent)resultList.get(0);
			
			Country country = null;
			try{
				country = em.createQuery("from Country c where c.longName=:name", Country.class).setParameter("name", ac.getLongName()).getSingleResult();
			}catch(NoResultException e){
				country = new Country();
				country.setShortName(ac.getShortName());
				country.setLongName(ac.getLongName());
			}
			admLevelOne.setCountry(country);
			
			
			
			em.persist(route);
			
			
			UserAlert ua = new UserAlert();
			ua.setDescription("Parece que a iluminação nas ruas do Distrito Federal é um problema enfrentado por muitos residentes da região norte.");
			String numero = streetNumber.getShortName()!=null?", "+streetNumber.getShortName():"";
			ua.setFormattedAddress(route.getShortName()+numero+" - "+sublocality.getShortName()+", "+locality.getShortName());
			Location location = new Location();
			location.setLat(String.valueOf(lat));
			location.setLng(String.valueOf(lng));
			GeoLocation radians = GeoLocation.convertDegreesToRadians(lat, lng);
			location.setLatRadian(String.valueOf(radians.getLatitudeInRadians()));
			location.setLngRadian(String.valueOf(radians.getLongitudeInRadians()));
			ua.setLocation(location);
			ua.setStreetNumber(streetNumber.getShortName());
			ua.setRoute(em.find(Route.class, route.getId()));
			ua.setAlertType(alertTypes.get(new Random().nextInt(alertTypes.size())));
			
			em.persist(ua);
			//***************************************************************
			em.getTransaction().commit();
			em.close();
			emf.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}

