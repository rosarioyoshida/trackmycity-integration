package br.com.trackmycity.exceptions;

public class UserException extends Exception {
	
	private static final long serialVersionUID = -3455232071568938955L;
	private int codeMessage;
	
	public UserException() {
		super();
	}

	public UserException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public UserException(int codeMessage, String message, Throwable cause) {
		super(message, cause);
		this.codeMessage = codeMessage;
	}
	
	public UserException(int codeMessage, String message) {
		super(message);
		this.codeMessage = codeMessage;
	}

	
	public UserException(String message) {
		super(message);
	}

	public UserException(Throwable cause) {
		super(cause);
	}
	
	public int getCodeMessage() {
		return codeMessage;
	}
	
}
