package com.api.service;

import com.api.filters.LoggingFilter;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {

	private String baseUri;
	private RequestSpecification requestSpec;

	static {

		RestAssured.filters(new LoggingFilter());
	}

	public BaseService(String baseUri) {
		super();
		this.baseUri = baseUri;
		this.initRequestSpecification();
	}

	public void initRequestSpecification() {
		requestSpec = RestAssured.given().baseUri(baseUri).contentType("application/json");
	}

	public Response get(String endpoint) {
		return requestSpec.get(endpoint);
	}

	public Response post(String endpoint, Object requestPayload) {
		return requestSpec.body(requestPayload).post(endpoint);
	}

	public Response put(String endpoint, Object requestPayload) {
		return requestSpec.body(requestPayload).put(endpoint);
	}

	public RequestSpecification setAuthToken(String token) {
		return requestSpec.header("Authorization", "Bearer " + token);
	}
}
