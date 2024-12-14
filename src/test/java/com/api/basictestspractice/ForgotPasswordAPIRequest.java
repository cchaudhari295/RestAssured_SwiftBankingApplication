package com.api.basictestspractice;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

import com.api.models.request.ForgotPasswordRequestPojo;
import com.utility.JSONUtility;

public class ForgotPasswordAPIRequest {

	
	public static void main(String[] args) {
		given()
			.baseUri("http://64.227.160.186:8080/api/auth")
			.header("Content-Type","application/json")
			.body(JSONUtility.convertToJSON(new ForgotPasswordRequestPojo("test999@gmail.com")))
			.log().all()
		.when()
			.post("forgot-password")
		.then()
			.log().all()
			.statusCode(200)
			.time(lessThan(10000L))
			.body("message", equalTo("If your email exists in our system, you will receive reset instructions."));
	}
}
