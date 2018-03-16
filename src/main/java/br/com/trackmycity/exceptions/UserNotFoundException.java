package br.com.trackmycity.exceptions;

public class UserNotFoundException extends Exception {
	
	private static final long serialVersionUID = -3455232071568938955L;
	private int codeMessage;
	
	public UserNotFoundException() {
		super();
	}

	public UserNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public UserNotFoundException(int codeMessage, String message, Throwable cause) {
		super(message, cause);
		this.codeMessage = codeMessage;
	}
	
	public UserNotFoundException(int codeMessage, String message) {
		super(message);
		this.codeMessage = codeMessage;
	}

	
	public UserNotFoundException(String message) {
		super(message);
	}

	public UserNotFoundException(Throwable cause) {
		super(cause);
	}
	
	public int getCodeMessage() {
		return codeMessage;
	}
	
}
