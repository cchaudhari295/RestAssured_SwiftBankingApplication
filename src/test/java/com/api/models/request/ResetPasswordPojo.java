package com.api.models.request;

public class ResetPasswordPojo {

	private String token;
	private String newPassword;
	private String confirmPassword;
	
	
	
	public ResetPasswordPojo(String token, String newPassword, String confirmPassword) {
		super();
		this.token = token;
		this.newPassword = newPassword;
		this.confirmPassword = confirmPassword;
	}



	@Override
	public String toString() {
		return "ResetPasswordPOJO [token=" + token + ", newPassword=" + newPassword + ", confirmPassword="
				+ confirmPassword + "]";
	}
	
	
}
