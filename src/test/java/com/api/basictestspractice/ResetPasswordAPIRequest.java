package com.api.basictestspractice;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

import com.api.models.request.ResetPasswordPojo;
import com.utility.JSONUtility;

public class ResetPasswordAPIRequest {

	public static void main(String[] args) {

		given()
		.baseUri("http://64.227.160.186:8080/api/auth")
		.header("Content-Type","application/json")
		.body(JSONUtility.convertToJSON(new ResetPasswordPojo("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJUZXN0IDEwMTEiLCJpYXQiOjE3MzI0Mjg1OTgsImV4cCI6MTczMjQzMjE5OH0.U6RTNgfc1SKYMCtgnqt_-ZT1hg3eyWSI2806XXJgiIo","password","password")))
		.log().all()
	.when()
		.post("reset-password")
	.then()
		.log().all()
		.statusCode(200)
		.time(lessThan(10000L))
		.body("message", equalTo("If your email exists in our system, you will receive reset instructions."));
	}

}
