package com.api.models.response;

import java.util.Arrays;

public class LoginResponsePojo {

private String token;
private String type;
private int id;
private String username;
private String email;
private String[] roles;

public LoginResponsePojo(String token, String type, int id, String username, String email, String[] roles) {
	super();
	this.token = token;
	this.type = type;
	this.id = id;
	this.username = username;
	this.email = email;
	this.roles = roles;
}
@Override
public String toString() {
	return "LoginResponsePOJO [token=" + token + ", type=" + type + ", id=" + id + ", username=" + username + ", email="
			+ email + ", roles=" + Arrays.toString(roles) + "]";
}
public String getToken() {
	return token;
}
public String getType() {
	return type;
}
public int getId() {
	return id;
}
public String getUsername() {
	return username;
}
public String getEmail() {
	return email;
}
public String[] getRoles() {
	return roles;
}


}
