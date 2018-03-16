package br.com.trackmycity.models;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.validator.constraints.NotBlank;

@MappedSuperclass
public abstract class AddressComponent extends GenericModel {

	private static final long serialVersionUID = -4177538435358759460L;
	
	@Column(name = "short_name")
	@NotBlank
	protected String shortName;
	@Column(name = "long_name")
	@NotBlank
	protected String longName;

	public String getLongName() {
		return longName;
	}
	public void setLongName(String longName) {
		this.longName = longName;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	
}
