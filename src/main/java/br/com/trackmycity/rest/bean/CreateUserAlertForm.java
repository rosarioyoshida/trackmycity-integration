package br.com.trackmycity.rest.bean;

import javax.ws.rs.FormParam;

public class CreateUserAlertForm {
	@FormParam("description")
	private String description;
	
	@FormParam("photo")
	private byte[] photo;
	
	@FormParam("lat")
	private String lat;
	
	@FormParam("lng")
	private String lng;
	
	@FormParam("alertTypeId")
	private Long alertTypeId;

	@FormParam("email")
	private String email;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
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

	public Long getAlertTypeId() {
		return alertTypeId;
	}

	public void setAlertTypeId(Long alertTypeId) {
		this.alertTypeId = alertTypeId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
