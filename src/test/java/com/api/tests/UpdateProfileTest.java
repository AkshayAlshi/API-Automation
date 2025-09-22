package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.request.ProfileRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class UpdateProfileTest {

	
	@Test(description="Verify update profile test")
	public void updateProfileTest() {
		
		AuthService authservice=new AuthService();
		Response response=authservice.login(new LoginRequest("Akshay", "Akshay@123"));
		LoginResponse loginresponse=response.as(LoginResponse.class);
		
		System.out.println("--------------------------------------------------------------------------");
		
		UserProfileManagementService UFMS= new UserProfileManagementService();
		response=UFMS.getProfile(loginresponse.getToken());
		System.out.println(response.asPrettyString());
		UserProfileResponse userprofileresponse= response.as(UserProfileResponse.class);
		Assert.assertEquals(userprofileresponse.getUsername(), "Akshay");
		
		System.out.println("--------------------------------------------------------------------------");
				
		ProfileRequest profilerequest=new ProfileRequest.Builder()
				.firstName("Aksay")
				.lastName("gawande")
				.email("akshay@gmail.com")
				.mobileNumber("7777777777")
				.build();
	
		response = UFMS.updateProfile(loginresponse.getToken(), profilerequest);
		System.out.println(response.asPrettyString());
	}
	
}
