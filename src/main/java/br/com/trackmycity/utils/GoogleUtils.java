package br.com.trackmycity.utils;

import static br.com.trackmycity.enumerations.FormatEnum.XML;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import br.com.trackmycity.beans.google.GeocodeResponse;
import br.com.trackmycity.enumerations.FormatEnum;
import br.com.trackmycity.producers.Google;

public class GoogleUtils {
	
	private ResourceBundle googleResourceBundle;
	
	@Inject
	public GoogleUtils(@Google ResourceBundle resourceBundle) {
		googleResourceBundle = resourceBundle;
	}
	
	public GeocodeResponse getAddressComponents(double lat, double lon) {
		try{
			InputStream is = loadGeoLocation(lat, lon, XML);
			JAXBContext ctx = JAXBContext.newInstance(GeocodeResponse.class);
			Unmarshaller unmarshaller = ctx.createUnmarshaller();
			GeocodeResponse response = (GeocodeResponse)unmarshaller.unmarshal(is);
			return response;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public InputStream loadGeoLocation(double lat, double lon, FormatEnum format) throws IOException {
		String string = googleResourceBundle.getString("google.api.maps");
		String stringURL = String.format(string, format.getValue(), lat, lon);
		URL googleURL = new URL(stringURL);
		InputStream is = googleURL.openStream();
		return is;
	}
	
}
