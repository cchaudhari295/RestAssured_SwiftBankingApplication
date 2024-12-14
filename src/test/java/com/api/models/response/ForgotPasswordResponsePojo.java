package com.api.models.response;

public class ForgotPasswordResponsePojo {

	private String message;

	public ForgotPasswordResponsePojo(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "ForgotPasswordResponsePOJO [message=" + message + "]";
	}

	public String getMessage() {
		return message;
	}
	
}
