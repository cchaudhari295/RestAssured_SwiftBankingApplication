package com.api.models.request;

public class LoginRequestPojo {

	private String username;
	private String password;
	
	public LoginRequestPojo(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "LoginRequestPOJO [username=" + username + ", password=" + password + "]";
	}

	
	
	
}
