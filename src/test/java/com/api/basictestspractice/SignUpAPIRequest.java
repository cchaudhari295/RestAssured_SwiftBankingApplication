package com.api.basictestspractice;

import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;

import com.api.models.request.SignUpRequestPojo;
import com.utility.JSONUtility;

public class SignUpAPIRequest {

	public static void main(String[] args) {

		given()
			.baseUri("http://64.227.160.186:8080/api/auth")
			.header("Content-Type","application/json")
			.body(JSONUtility.convertToJSON(new SignUpRequestPojo("Test 1011","password","test1011@gmail.com","Test1011","User","9787667838")))
			.log().all()
		.when()
			.post("signup")
		.then()
			.log().all()
			.statusCode(400)
			.time(Matchers.lessThan(5000L))
			//.body(Matchers.equalTo("User registered successfully!"));
			.body(Matchers.equalTo("Error: Username is already taken!"));

		System.out.println("PASSED");
	}

}


