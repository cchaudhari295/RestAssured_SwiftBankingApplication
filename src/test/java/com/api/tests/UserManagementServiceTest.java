package com.api.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.api.models.request.ChangePasswordRequestPojo;
import com.api.models.request.LoginRequestPojo;
import com.api.models.request.UpdateProfileRequestPojo;
import com.api.models.response.LoginResponsePojo;
import com.api.models.response.UserManagementResponsePojo;
import com.api.service.AuthenticationService;
import com.api.service.UserManagementService;

import io.restassured.response.Response;

public class UserManagementServiceTest {

	private static final String baseUri="http://64.227.160.186:8080";
	private UserManagementService userManagementService;
	private AuthenticationService authService;
	String token;

	@BeforeMethod
	public void setUp() {
		authService = new AuthenticationService(baseUri);
		LoginRequestPojo loginRequest=new LoginRequestPojo("chaitali", "password1234");
		Response response=authService.login(loginRequest);
		LoginResponsePojo loginResponse=response.as(LoginResponsePojo.class);
		token=loginResponse.getToken();
		System.out.println(loginResponse.getToken());
	}
	@Test 
	
	public void changePasswordTest() {
		userManagementService=new UserManagementService(baseUri);
		ChangePasswordRequestPojo changePasswordRequestPojo = new ChangePasswordRequestPojo("password123", "password1234", "password1234");
		Response response= userManagementService.changePassword(token, changePasswordRequestPojo);
		System.out.println("Response: "+response.asPrettyString());
	}
	
	@Test
	public void getProfileTest() {
		userManagementService=new UserManagementService(baseUri);
		Response response=userManagementService.getProfile(token);
		UserManagementResponsePojo userManagementResponsePojo=response.as(UserManagementResponsePojo.class);
		System.out.println(userManagementResponsePojo);	
		Assert.assertEquals(userManagementResponsePojo.getUsername(), "Chaitali");
	}
	
	
	@Test
	public void updateProfileTest() {
		
		userManagementService=new UserManagementService(baseUri);
		UpdateProfileRequestPojo updateProfileRequestPojo = new UpdateProfileRequestPojo("chaitali","C","chaitali1.chaudhari@gmail.com","9762123456");
		Response response = userManagementService.updateProfile(token, updateProfileRequestPojo);
		System.out.println(response.asPrettyString());
		UserManagementResponsePojo userManagementResponsePojo=response.as(UserManagementResponsePojo.class);
		System.out.println(userManagementResponsePojo);
		Assert.assertEquals(userManagementResponsePojo.getUsername(), "Chaitali");
	}
}
