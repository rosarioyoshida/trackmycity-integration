package br.com.trackmycity.models;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class GenericModel implements Serializable {

	private static final long serialVersionUID = -1348766793212038990L;

}
