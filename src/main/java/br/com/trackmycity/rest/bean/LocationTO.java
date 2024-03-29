package br.com.trackmycity.rest.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LocationTO {
	
	private Double lat;
	private Double lng;
	private Double distance;
	
	public LocationTO() {
		super();
	}
	
	public LocationTO(Double lat, Double lng, Double distance) {
		super();
		this.lat = lat;
		this.lng = lng;
		this.distance = distance;
	}
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public Double getLng() {
		return lng;
	}
	public void setLng(Double lng) {
		this.lng = lng;
	}
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	
}