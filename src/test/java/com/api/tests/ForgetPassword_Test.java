package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;

import io.restassured.response.Response;

public class ForgetPassword_Test {
	
	
	@Test(description="Verify forget password....")
	public void verifyForgetPass() {
		
		AuthService authservice=new AuthService();
		Response response =authservice.forgetPassword("akas@gmail.com");
		System.out.println(response.asPrettyString());
	}

}
