package br.com.trackmycity.config.jackson;

import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class JacksonConfig implements ContextResolver<ObjectMapper>{

	private final ObjectMapper objectMapper;
	private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", new Locale("pt", "BR"));
	
	public JacksonConfig() {
		this.objectMapper = new ObjectMapper();
		this.objectMapper.setDateFormat(simpleDateFormat);
		this.objectMapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
		this.objectMapper.configure(SerializationConfig.Feature.DEFAULT_VIEW_INCLUSION, false);
	}
	
	@Override
	public ObjectMapper getContext(Class<?> arg0) {
		return objectMapper;
	}
	
}
