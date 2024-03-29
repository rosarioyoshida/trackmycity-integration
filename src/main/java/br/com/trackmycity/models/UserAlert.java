package br.com.trackmycity.models;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonView;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.NotBlank;

import br.com.trackmycity.config.jackson.Views;
import br.com.trackmycity.models.embeddable.Location;

@Entity
@Table(name = "USER_ALERT")
@XmlRootElement(name = "user_alert") @XmlAccessorType(XmlAccessType.FIELD)
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class UserAlert extends GenericModel {

	private static final long serialVersionUID = 2547406582924032457L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@JsonView({Views.UserAlertsOnMap.class, Views.UserAlertDetail.class})
	private Long id;
	@NotBlank
	@JsonView(Views.UserAlertDetail.class)
	private String description;
	@Lob
	private byte[] photo;
	private String streetNumber;
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY, optional = false)
	private Route route;
	@Embedded
	@JsonView({Views.UserAlertsOnMap.class, Views.UserAlertDetail.class})
	private Location location;
	@JsonView({Views.UserAlertsOnMap.class, Views.UserAlertDetail.class})
	private String formattedAddress;
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "alert_type_id")
	@JsonView({Views.UserAlertsOnMap.class, Views.UserAlertDetail.class})
	private AlertType alertType;
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY, optional = false)
	@JsonView(Views.UserAlertDetail.class)
	private User user;
	
	
	public UserAlert() {
		super();
	}
	
	public UserAlert(byte[] photo) {
		super();
		this.photo = photo;
	}



	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
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

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getFormattedAddress() {
		return formattedAddress;
	}

	public void setFormattedAddress(String formattedAddress) {
		this.formattedAddress = formattedAddress;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public AlertType getAlertType() {
		return alertType;
	}

	public void setAlertType(AlertType alertType) {
		this.alertType = alertType;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
