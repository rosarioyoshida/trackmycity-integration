package br.com.trackmycity.helper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.NoResultException;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;

import br.com.trackmycity.beans.google.AddressComponent;
import br.com.trackmycity.beans.google.Result;
import br.com.trackmycity.dao.AdmLevelOneDAO;
import br.com.trackmycity.dao.CountryDAO;
import br.com.trackmycity.dao.LocalityDAO;
import br.com.trackmycity.dao.RouteDAO;
import br.com.trackmycity.dao.SublocalityDAO;
import br.com.trackmycity.enumerations.MapsTypeEnum;
import br.com.trackmycity.models.AdmLevelOne;
import br.com.trackmycity.models.Country;
import br.com.trackmycity.models.Locality;
import br.com.trackmycity.models.Route;
import br.com.trackmycity.models.Sublocality;

public class GoogleHelper implements Serializable {

	private static final long serialVersionUID = 307295116238842499L;
	private List<Result> results;
	private Route route;
	private String streetNumber;
	
	
	private RouteDAO routeDAO;
	private SublocalityDAO sublocalityDAO;
	private LocalityDAO localityDAO;
	private AdmLevelOneDAO admLevelOneDAO;
	private CountryDAO countryDAO;
	
	@Inject
	public GoogleHelper(RouteDAO routeDAO, SublocalityDAO sublocalityDAO, LocalityDAO localityDAO, AdmLevelOneDAO admLevelOneDAO, CountryDAO countryDAO) {
		super();
		this.routeDAO = routeDAO;
		this.sublocalityDAO = sublocalityDAO;
		this.localityDAO = localityDAO;
		this.admLevelOneDAO = admLevelOneDAO;
		this.countryDAO = countryDAO;
	}
	
	public Route getRoute(List<Result> results)	{
		this.results = results;
		
		if(route == null) {
			List<AddressComponent> resultList = new ArrayList<AddressComponent>();
			CollectionUtils.select(results.get(0).getAddressComponents(), new RoutePredicate(), resultList);
			
			AddressComponent ac = resultList.get(0);
	
			try{
				route = routeDAO.findByName(ac.getShortName());
			}catch(NoResultException e){
				route = new Route();
				route.setShortName(ac.getShortName());
				route.setLongName(ac.getLongName());
			}
		}
		route.setSublocality(getSublocality());
		return route;
	}
	
	public String getStreetNumber() {
		List<AddressComponent> resultList = new ArrayList<AddressComponent>();
		CollectionUtils.select(results.get(0).getAddressComponents(), new StreetNumberPredicate(), resultList);
		AddressComponent ac = resultList.get(0);
		return ac.getShortName();
	}

	public Sublocality getSublocality() {
		List<AddressComponent> resultList = new ArrayList<AddressComponent>();
		CollectionUtils.select(results.get(0).getAddressComponents(), new SublocalityPredicate(), resultList);
		
		Sublocality sublocality = null;
		AddressComponent ac = (AddressComponent)resultList.get(0);
		try{
			sublocality = sublocalityDAO.findByName(ac.getShortName());
		}catch(NoResultException e){
			sublocality = new Sublocality();
			sublocality.setShortName(ac.getShortName());
			sublocality.setLongName(ac.getLongName());
		}
		sublocality.setLocality(getLocality());
		return sublocality;
	}

	public Locality getLocality() {
		List<AddressComponent> resultList = new ArrayList<AddressComponent>();
		CollectionUtils.select(results.get(0).getAddressComponents(), new LocalityPredicate(), resultList);
		
		Locality locality = null;
		AddressComponent ac = (AddressComponent)resultList.get(0);
		try{
			locality = localityDAO.findByName(ac.getShortName());
		}catch(NoResultException e){
			locality = new Locality();
			locality.setShortName(ac.getShortName());
			locality.setLongName(ac.getLongName());
		}
		locality.setAdmLevelOne(getAdmLevelOne());
		return locality;
	}

	public AdmLevelOne getAdmLevelOne() {
		List<AddressComponent> resultList = new ArrayList<AddressComponent>();
		CollectionUtils.select(results.get(0).getAddressComponents(), new AdmLevelOnePredicate(), resultList);
		AddressComponent ac = (AddressComponent)resultList.get(0);
		
		AdmLevelOne admLevelOne = null;
		
		try{
			admLevelOne = admLevelOneDAO.findByName(ac.getShortName());
		}catch(NoResultException e){
			admLevelOne = new AdmLevelOne();
			admLevelOne.setLongName(ac.getLongName());
			admLevelOne.setShortName(ac.getShortName());
		}
		admLevelOne.setCountry(getcountry());
		return admLevelOne;
	}

	public Country getcountry() {
		List<AddressComponent> resultList = new ArrayList<AddressComponent>();
		CollectionUtils.select(results.get(0).getAddressComponents(), new CountryPredicate(), resultList);
		
		AddressComponent ac = (AddressComponent)resultList.get(0);
		
		Country country = null;
		try{
			country = countryDAO.findByName(ac.getShortName());
		}catch(NoResultException e){
			country = new Country();
			country.setShortName(ac.getShortName());
			country.setLongName(ac.getLongName());
		}
		
		return country;
	}

}

class RoutePredicate implements Predicate {
	
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
	
}


class StreetNumberPredicate implements Predicate {
	
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
	
}

class SublocalityPredicate implements Predicate {
	
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
	
}

class LocalityPredicate implements Predicate {
	
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
	
}

class AdmLevelOnePredicate implements Predicate {
	
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
	
}

class CountryPredicate implements Predicate {
	
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
	
}
