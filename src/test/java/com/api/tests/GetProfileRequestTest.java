package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class GetProfileRequestTest {

	
	@Test
	public void getProfileInfoTest() {
		
		AuthService authservice =new AuthService();
		Response response=authservice.login(new LoginRequest("Akshay","Akshay@123"));
		LoginResponse loginresponse=response.as(LoginResponse.class);
		System.out.println(loginresponse.getToken());
		
		
		UserProfileManagementService UFMS= new UserProfileManagementService();
		response =UFMS.getProfile(loginresponse.getToken());
		UserProfileResponse userprofileresponse=	response.as(UserProfileResponse.class);
		System.out.println(userprofileresponse.getUsername());
		System.out.println(userprofileresponse.getFirstName());
		System.out.println(userprofileresponse.getMobileNumber());
		
	}
}
