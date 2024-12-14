package com.api.models.request;

public class ForgotPasswordRequestPojo {
private String email;

public ForgotPasswordRequestPojo(String email) {
	super();
	this.email = email;
}

@Override
public String toString() {
	return "ForgotPasswordPOJO [email=" + email + "]";
}

}
