package br.com.trackmycity.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "ROUTE")
@XmlRootElement(name = "route") @XmlAccessorType(XmlAccessType.FIELD)
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Route extends AddressComponent {

	private static final long serialVersionUID = 3087878576163305929L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY, optional = false)
	private Sublocality sublocality;

	public Sublocality getSublocality() {
		return sublocality;
	}

	public void setSublocality(Sublocality sublocality) {
		this.sublocality = sublocality;
	}

	public Long getId() {
		return id;
	}
	
}
