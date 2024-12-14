package com.api.models.response;

public class ResetPasswordResponsePojo {
	
	private String message;

	public ResetPasswordResponsePojo(String message) {
		super();
		this.message = message;
	}

	
	@Override
	public String toString() {
		return "ResetPasswordResponsePojo [message=" + message + "]";
	}


	public String getMessage() {
		return message;
	}
	
	
}
