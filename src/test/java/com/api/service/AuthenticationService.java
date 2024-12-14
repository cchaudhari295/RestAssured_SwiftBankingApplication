package com.api.service;

import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AuthenticationService extends BaseService {

	private static final String AUTH_ROUTE="/api/auth/";

	
	public AuthenticationService(String baseUri) {
		super(baseUri);
	}

	public Response login(Object payload) {
		return post(AUTH_ROUTE + "login",payload);	
	}
	
	public Response signUp(Object payload) {
		return post(AUTH_ROUTE+"signup",payload);
	}
	
	public Response forgotPassword(Object payload) {
		return post(AUTH_ROUTE+"forgot-password",payload);
	}
	
	public Response forgotPassword(String emailAddress) {
		HashMap<String,String> payload=new HashMap<String, String>();
		payload.put("email", emailAddress);
		return post(AUTH_ROUTE+"forgot-password",payload);
	}
	
	
	public Response resetPassword(Object payload) {
		return post(AUTH_ROUTE+"reset-password",payload);
	}
	
	
	
}
