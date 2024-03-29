package br.com.trackmycity.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonView;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import br.com.trackmycity.config.jackson.Views;

@Entity
@Table(name = "USER")
@XmlRootElement(name = "user") @XmlAccessorType(XmlAccessType.FIELD)
public class User extends GenericModel {
	
	private static final long serialVersionUID = -7193943360601579256L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@JsonView(Views.UserAlertDetail.class)
	private Long id;
	
	@NotBlank
	@JsonView(Views.UserAlertDetail.class)
	private String name;
	
	@Column(name = "email", unique = true) 
	@Email
	@JsonView(Views.UserAlertDetail.class)
	private String email;
	
	@NotBlank
	private String password;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private Set<UserAlert> alerts;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY, optional = false)
	@JsonView(Views.UserAlertDetail.class)
	private SocialNetworkType socialNetworkType;

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public Set<UserAlert> getAlerts() {
		return alerts;
	}

	public void setAlerts(Set<UserAlert> alerts) {
		this.alerts = alerts;
	}

	public SocialNetworkType getSocialNetworkType() {
		return socialNetworkType;
	}

	public void setSocialNetworkType(SocialNetworkType socialNetworkType) {
		this.socialNetworkType = socialNetworkType;
	}
	
}
