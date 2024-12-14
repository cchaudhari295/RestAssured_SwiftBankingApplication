package com.api.models.request;

public class SignUpRequestPojo {

	private String username;
	private String password;
	private String email;
	private String firstName;
	private String lastName;
	private String mobileNumber;
	
	
	public SignUpRequestPojo(String username, String password, String email, String firstName, String lastName,
			String mobileNumber) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
	}
	
	@Override
	public String toString() {
		return "SignUpPOJO [username=" + username + ", password=" + password + ", email=" + email + ", firstName="
				+ firstName + ", lastName=" + lastName + ", mobileNumber=" + mobileNumber + "]";
	}
	
	public static class Builder {
		private String username;
		private String password;
		private String email;
		private String firstName;
		private String lastName;
		private String mobileNumber;
		
		public Builder username(String username) {
			this.username=username;
			return this;
		}
		
		public Builder password(String password) {
			this.password=password;
			return this;
		}
		
		public Builder email(String email) {
			this.email=email;
			return this;
		}
		
		public Builder firstName(String firstName) {
			this.firstName=firstName;
			return this;
		}
		
		public Builder lastName(String lastName) {
			this.lastName=lastName;
			return this;
		}
		
		public Builder mobileNumber(String mobileNumber) {
			this.mobileNumber=mobileNumber;
			return this;
		}
		
		public SignUpRequestPojo build() {
			SignUpRequestPojo signUpPojo = new SignUpRequestPojo(username, password, email, firstName, lastName, mobileNumber);
			return signUpPojo;
		}
		
	}
	
}
