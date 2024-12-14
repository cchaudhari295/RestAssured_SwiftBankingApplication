package com.api.service;

import io.restassured.response.Response;

public class UserManagementService extends BaseService {

	private static final String USER_MANAGEMENT_ROUTE = "/api/users/";

	public UserManagementService(String baseUri) {
		super(baseUri);
	}

	public Response changePassword(String token, Object changePasswordRequestPayload) {
		setAuthToken(token);
		return put(USER_MANAGEMENT_ROUTE + "change-password", changePasswordRequestPayload);
	}

	public Response getProfile(String token) {
		setAuthToken(token);
		return get(USER_MANAGEMENT_ROUTE + "profile");
	}
	
	public Response updateProfile(String token,Object payload) {
		setAuthToken(token);
		return put(USER_MANAGEMENT_ROUTE + "profile",payload);
	}
}
