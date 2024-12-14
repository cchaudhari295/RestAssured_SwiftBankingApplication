package com.api.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.models.request.ForgotPasswordRequestPojo;
import com.api.models.request.LoginRequestPojo;
import com.api.models.request.ResetPasswordPojo;
import com.api.models.request.SignUpRequestPojo;
import com.api.models.response.ForgotPasswordResponsePojo;
import com.api.models.response.LoginResponsePojo;
import com.api.models.response.ResetPasswordResponsePojo;
import com.api.service.AuthenticationService;

import io.restassured.response.Response;

@Listeners(com.api.listeners.TestListeners.class)

public class AuthenticationServiceTest {
	private AuthenticationService authService;
	private static final String baseUrl = "http://64.227.160.186:8080";


	
	@Test
	public void loginWithValidCredentialsTest() {
		authService = new AuthenticationService(baseUrl);
		LoginRequestPojo loginRequest = new LoginRequestPojo("chaitali", "password1234");
		Response response = authService.login(loginRequest);
		System.out.println(response.asPrettyString());
		LoginResponsePojo loginResponse = response.as(LoginResponsePojo.class);
		System.out.println(loginResponse);
	}
	
	@Test
	public void signUpWithValidDetailsTest() {
		authService = new AuthenticationService(baseUrl);
		SignUpRequestPojo signUpPOJO = new SignUpRequestPojo("Test 8891", "password", "test8891@gmail.com", "Test8881", "User8891", "9876543210");
		Response response=authService.signUp(signUpPOJO);	
		Assert.assertEquals(response.asPrettyString(), "User registered successfully!");
	}
	
	//Using Builder design pattern
	@Test
	public void signUpWithValidDetailsUsingBDPTest() {
		authService = new AuthenticationService(baseUrl);		
		SignUpRequestPojo signUpPojo = new SignUpRequestPojo.Builder().username("Test 111")
		.email("test111@gmail.com")
		.firstName("User111")
		.mobileNumber("9876543234")
		.lastName("Test111")
		.password("password")
		.build();
		
		Response response=authService.signUp(signUpPojo);	
		Assert.assertEquals(response.asPrettyString(), "User registered successfully!");
	}
	
	
	// Using HashMap as it is having only 1 key
	@Test
	public void forgotPasswordTest() {
		authService = new AuthenticationService(baseUrl);
		Response response=authService.forgotPassword("test999@gmail.com");
		ForgotPasswordResponsePojo forgotPasswordResponse=response.as(ForgotPasswordResponsePojo.class);
		Assert.assertEquals(forgotPasswordResponse.getMessage(), "If your email exists in our system, you will receive reset instructions.");
	}
	
	@Test
	public void resetPasswordTest() {
		authService = new AuthenticationService(baseUrl);
		LoginRequestPojo loginRequest=new LoginRequestPojo("chaitali", "password");
		Response response=authService.login(loginRequest);
		LoginResponsePojo loginResponse=response.as(LoginResponsePojo.class);
		System.out.println(loginResponse.getToken());
		ResetPasswordPojo resetPasswordRequest = new ResetPasswordPojo(loginResponse.getToken(),"password123","password123");
		Response resetResponse=authService.resetPassword(resetPasswordRequest);
		ResetPasswordResponsePojo resetPasswordResponse=resetResponse.as(ResetPasswordResponsePojo.class);
		Assert.assertEquals(resetPasswordResponse.getMessage(), "If your email exists in our system, you will receive reset instructions.");
	}
	
}
