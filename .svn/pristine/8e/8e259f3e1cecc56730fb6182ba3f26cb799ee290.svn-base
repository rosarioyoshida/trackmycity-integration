package br.com.trackmycity.exceptions;

public class UserEmailFoundException extends Exception {
	
	private static final long serialVersionUID = -3455232071568938955L;
	private int codeMessage;
	
	public UserEmailFoundException() {
		super();
	}

	public UserEmailFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public UserEmailFoundException(int codeMessage, String message, Throwable cause) {
		super(message, cause);
		this.codeMessage = codeMessage;
	}
	
	public UserEmailFoundException(int codeMessage, String message) {
		super(message);
		this.codeMessage = codeMessage;
	}

	
	public UserEmailFoundException(String message) {
		super(message);
	}

	public UserEmailFoundException(Throwable cause) {
		super(cause);
	}
	
	public int getCodeMessage() {
		return codeMessage;
	}
	
}
