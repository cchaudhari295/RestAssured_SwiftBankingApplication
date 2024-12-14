package com.api.basictestspractice;

import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.*;

import com.api.models.request.LoginRequestPojo;
import com.api.models.response.LoginResponsePojo;
import com.utility.JSONUtility;

public class LoginAPIRequest {
	public static void main(String[] args) {
		loginWithValidCredentials();
		loginWithInValidCredentials();
	}
	
		public static void loginWithValidCredentials() {
			LoginResponsePojo loginResponsePOJO=	given()
				.baseUri("http://64.227.160.186:8080/api/auth")
				.header("Content-Type","application/json")
				.body(JSONUtility.convertToJSON(new LoginRequestPojo("Test 1011","password")))
				.log().all()
			.when()
				.post("login")
			.then()
				.log().all()
				.statusCode(200)
				.time(lessThan(5000L))
				.body("username", equalTo("Test 1011"))
				.body("email",equalTo("test1011@gmail.com"))
				.body("token", notNullValue())
				.extract().as(LoginResponsePojo.class);
				
			System.out.println(loginResponsePOJO);
		}
		
		public static void loginWithInValidCredentials() {
			given()
				.baseUri("http://64.227.160.186:8080/api/auth")
				.header("Content-Type","application/json")
				.body(JSONUtility.convertToJSON(new LoginRequestPojo("Test 11","passwrd")))
				.log().all()
			.when()
				.post("login")
			.then()
				.log().all()
				.statusCode(401)
				.time(lessThan(5000L))
				.body("error", equalTo("Unauthorized"))
				.body("message",equalTo("Bad credentials"));
		}
		
}
