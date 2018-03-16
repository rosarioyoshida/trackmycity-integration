package br.com.trackmycity.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class ResourceBundleUtils {
	
	private static final Map<String, ResourceBundle> resourceBundleMap = new HashMap<String, ResourceBundle>();
	
	public static ResourceBundle getGoogleResourceBundle(){
		ResourceBundle googleResourceBundle = resourceBundleMap.get("br.com.trackmycity.resources.google");
		if(googleResourceBundle == null){
			resourceBundleMap.put("br.com.trackmycity.resources.google", ResourceBundle.getBundle("br.com.trackmycity.resources.google"));
			googleResourceBundle = resourceBundleMap.get("br.com.trackmycity.resources.google");
		}
		return googleResourceBundle;
	}

}
