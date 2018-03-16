package br.com.trackmycity.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonView;
import org.hibernate.validator.constraints.NotBlank;

import br.com.trackmycity.config.jackson.Views;

@Entity
@Table(name = "SOCIAL_NETWORK_TYPE")
@XmlRootElement(name = "socialNetworkType") @XmlAccessorType(XmlAccessType.FIELD)
public class SocialNetworkType extends GenericModel {
	
	private static final long serialVersionUID = 7783896317260711107L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@JsonView(Views.UserAlertDetail.class)
	private Long id;
	@NotBlank
	@JsonView(Views.UserAlertDetail.class)
	private String name;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	
}
