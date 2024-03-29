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
@Table(name = "LOCALITY")
@XmlRootElement(name = "locality") @XmlAccessorType(XmlAccessType.FIELD)
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Locality extends AddressComponent {

	private static final long serialVersionUID = 7141463337948552156L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
	private AdmLevelOne admLevelOne;

	public AdmLevelOne getAdmLevelOne() {
		return admLevelOne;
	}

	public void setAdmLevelOne(AdmLevelOne admLevelOne) {
		this.admLevelOne = admLevelOne;
	}

	public Long getId() {
		return id;
	}
	
}
