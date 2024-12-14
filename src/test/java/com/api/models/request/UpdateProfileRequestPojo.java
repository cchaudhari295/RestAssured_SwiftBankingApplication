package com.api.models.request;

public class UpdateProfileRequestPojo {

	private String firstName;
	private String lastName;
	private String email;
	private String mobileNumber;
	
	public UpdateProfileRequestPojo(String firstName, String lastName, String email, String mobileNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNumber = mobileNumber;
	}
	@Override
	public String toString() {
		return "UpdateProfileRequestPojo [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", mobileNumber=" + mobileNumber + "]";
	}
	
	
}
