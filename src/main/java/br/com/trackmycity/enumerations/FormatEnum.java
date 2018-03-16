package br.com.trackmycity.enumerations;

public enum FormatEnum {

	JSON("json"), XML("xml");
	
	String value;

	private FormatEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
