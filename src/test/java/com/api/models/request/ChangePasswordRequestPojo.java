package com.api.models.request;

public class ChangePasswordRequestPojo {

	private String currentPassword;
	private String newPassword;
	private String confirmPassword;
	public ChangePasswordRequestPojo(String currentPassword, String newPassword, String confirmPassword) {
		super();
		this.currentPassword = currentPassword;
		this.newPassword = newPassword;
		this.confirmPassword = confirmPassword;
	}
	
	@Override
	public String toString() {
		return "ChangePasswordRequestPojo [currentPassword=" + currentPassword + ", newPassword=" + newPassword
				+ ", confirmPassword=" + confirmPassword + "]";
	}
	
	
	
}
