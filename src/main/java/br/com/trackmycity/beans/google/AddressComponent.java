package br.com.trackmycity.beans.google;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.trackmycity.enumerations.MapsTypeEnum;

@XmlRootElement(name = "address_component")
@XmlAccessorType(XmlAccessType.FIELD)
public class AddressComponent {
	
	@XmlElement(name = "type")
	private List<MapsTypeEnum> types;
	@XmlElement(name = "short_name")
	private String shortName;
	@XmlElement(name = "long_name")
	private String longName;
	
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

	public List<MapsTypeEnum> getTypes() {
		return types;
	}

	public void setTypes(List<MapsTypeEnum> types) {
		this.types = types;
	}
	
}
