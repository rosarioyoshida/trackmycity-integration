package br.com.trackmycity.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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

@Entity
@Table(name = "ALERT_TYPE")
@XmlRootElement(name = "alert_type") @XmlAccessorType(XmlAccessType.FIELD)
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class AlertType extends GenericModel {

	private static final long serialVersionUID = 8590100012906968484L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@JsonView({Views.UserAlertsOnMap.class, Views.UserAlertDetail.class})
	private Long id;
	@NotBlank
	@JsonView({Views.UserAlertsOnMap.class, Views.UserAlertDetail.class})
	private String name;
	@JsonView({Views.UserAlertsOnMap.class, Views.UserAlertDetail.class})
	private String iconMenu;
	@JsonView({Views.UserAlertsOnMap.class, Views.UserAlertDetail.class})
	private String iconMap;
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "group_type_id")
	private AlertGroupType alertGroupType;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public AlertGroupType getAlertGroupType() {
		return alertGroupType;
	}
	
	public void setAlertGroupType(AlertGroupType alertGroupType) {
		this.alertGroupType = alertGroupType;
	}

	public Long getId() {
		return id;
	}

	public String getIconMenu() {
		return iconMenu;
	}

	public void setIconMenu(String iconMenu) {
		this.iconMenu = iconMenu;
	}

	public String getIconMap() {
		return iconMap;
	}

	public void setIconMap(String iconMap) {
		this.iconMap = iconMap;
	}

	public AlertType setId(Long id) {
		this.id = id;
		return this;
	}
	
}
