package br.com.trackmycity.response;

import java.io.Serializable;

import org.codehaus.jackson.map.annotate.JsonView;

import br.com.trackmycity.config.jackson.Views;
import br.com.trackmycity.config.jackson.Views.ResponseBaseView;
import br.com.trackmycity.models.GenericModel;

public abstract class ResponseBase implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonView(Views.UserAlertDetail.class)
	private GenericModel genericModel;
	@JsonView(Views.UserAlertDetail.class)
	private int returnCode;
	@JsonView(Views.UserAlertDetail.class)
	private String returnMessage;
	
	public static final int RETURN_CODE_SUCCESS = 0;
	public static final String RETURN_MESSAGE_SUCCESS = "Sucesso";
	public static final int RETURN_CODE_ERROR = 1;
	public static final String RETURN_MESSAGE_ERROR = "Ocorreu um erro inesperado";
	
	public ResponseBase(GenericModel genericModel, int returnCode,
			String returnMessage) {
		super();
		this.genericModel = genericModel;
		this.returnCode = returnCode;
		this.returnMessage = returnMessage;
	}

	public GenericModel getGenericModel() {
		return genericModel;
	}

	public int getReturnCode() {
		return returnCode;
	}

	public String getReturnMessage() {
		return returnMessage;
	}
	
	
}
