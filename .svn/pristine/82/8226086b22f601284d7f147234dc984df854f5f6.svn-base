package br.com.trackmycity.beans.google;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.trackmycity.enumerations.MapsStatusEnum;


@XmlRootElement(name = "GeocodeResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class GeocodeResponse {
	@XmlElement(name = "status")
	private MapsStatusEnum status;
	@XmlElement(name = "result")
	private List<Result> results;
	
	public MapsStatusEnum getStatus() {
		return status;
	}
	
	public void setStatus(MapsStatusEnum status) {
		this.status = status;
	}

	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}
	
}
