package br.com.trackmycity.beans.google;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.trackmycity.enumerations.MapsTypeEnum;

@XmlRootElement(name = "result")
@XmlAccessorType(XmlAccessType.FIELD)
public class Result {
	
	@XmlElement(name = "type")
	private List<MapsTypeEnum> types;
	@XmlElement(name = "formatted_address")
	private String formattedAddress;
	@XmlElement(name = "address_component")
	private List<AddressComponent> addressComponents;

	public List<MapsTypeEnum> getTypes() {
		return types;
	}

	public void setTypes(List<MapsTypeEnum> types) {
		this.types = types;
	}

	public String getFormattedAddress() {
		return formattedAddress;
	}
	
	public void setFormattedAddress(String formattedAddress) {
		this.formattedAddress = formattedAddress;
	}
	
	public List<AddressComponent> getAddressComponents() {
		return addressComponents;
	}
	
	public void setAddressComponents(List<AddressComponent> addressComponents) {
		this.addressComponents = addressComponents;
	}
	
}
