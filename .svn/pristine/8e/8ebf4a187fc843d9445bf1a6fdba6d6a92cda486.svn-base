package br.com.trackmycity.models.embeddable;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.codehaus.jackson.map.annotate.JsonView;
import org.hibernate.validator.constraints.NotBlank;

import br.com.trackmycity.config.jackson.Views;

@Embeddable
public class Location implements Serializable {

	private static final long serialVersionUID = -512953279422933536L;

	@Column(name = "lat")
	@NotBlank
	@JsonView({Views.UserAlertsOnMap.class, Views.UserAlertDetail.class})
	private String lat;
	@Column(name = "lng")
	@NotBlank
	@JsonView({Views.UserAlertsOnMap.class, Views.UserAlertDetail.class})
	private String lng;
	@Column(name = "lat_radian")
	@NotBlank
	private String latRadian;
	@Column(name = "lng_radian")
	@NotBlank
	private String lngRadian;
	
	public Location() {
		super();
	}

	public Location(String lat, String lng) {
		super();
		this.lat = lat;
		this.lng = lng;
	}

	public String getLat() {
		return lat;
	}
	
	public void setLat(String lat) {
		this.lat = lat;
	}
	
	public String getLng() {
		return lng;
	}
	
	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getLatRadian() {
		return latRadian;
	}

	public void setLatRadian(String latRadian) {
		this.latRadian = latRadian;
	}

	public String getLngRadian() {
		return lngRadian;
	}

	public void setLngRadian(String lngRadian) {
		this.lngRadian = lngRadian;
	}
	
}
