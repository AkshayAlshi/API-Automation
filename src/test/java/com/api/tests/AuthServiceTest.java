package com.api.tests;

import org.testng.annotations.Test;

import com.api.Services.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

public class AuthServiceTest {

	
	
	@Test(description="Verify forget password....")
	public void verifyForgetPass() {
		
		AuthService authservice=new AuthService();
		Response response =authservice.forgetPassword("akas@gmail.com");
		System.out.println(response.asPrettyString());
	}
	
	
	@Test(description="verify login api ")
	public void login() {
		LoginRequest loginrequest=new LoginRequest("Akshay","Akshay@123");//pojo
		AuthService authservice=new AuthService();
		Response response=authservice.login(loginrequest);
		LoginResponse loginresponse=response.as(LoginResponse.class);
		System.out.println(response.asPrettyString());
		System.out.println(loginresponse.getToken());
		
	}
	
	
	

}
