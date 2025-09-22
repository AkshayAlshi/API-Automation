package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;

public class AccountCreatetionTest {

	
	@Test(description="Verify account creation ")
	public void accountCreatetionTest() {
		
		SignUpRequest signuprequest =new SignUpRequest.Builder()
		.userName("aksah1")
		.password("aksha@1234")
		.email("akas@gmail.com")
		.firstName("yogesh")
		.lastName("raut")
		.mobileNumber("1111111111")
		.build();
		
		System.out.println(signuprequest);
		AuthService authservice=new AuthService();
		Response response = authservice.signUp(signuprequest);
		System.out.println(response.asPrettyString());

	}
}
