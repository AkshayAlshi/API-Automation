package com.api.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


@Listeners(com.api.listners.TestListners.class)
public class LoginApiTest {
	
	@Test(description = "Verify Login Api")
	public void loginTest() {
		
//		RestAssured.baseURI="http://64.227.160.186:8080";
		
		//OLD CODE
		
		
//		RequestSpecification x=RestAssured.given();
//		RequestSpecification y=x.header("Content-Type","application/json");
//		RequestSpecification z=y.body("{\r\n"
//				+ "  \"username\": \"Akshay\",\r\n"
//				+ "  \"password\": \"Akshay@123\"\r\n"
//				+ "}");                                     // 1st code
//		Response response=z.post("/api/auth/login");
//		System.out.println(response.asPrettyString());
		
		
		//Code Optimization New Code
//		
//		Response response=RestAssured.given()
//				.baseUri("http://64.227.160.186:8080")
//				.header("Content-Type","application/json")
//				.body("{\r\n"                                // 2nd code
//				+ "  \"username\": \"Akshay\",\r\n"
//				+ "  \"password\": \"Akshay@123\"\r\n"
//				+ "}")
//				.post("/api/auth/login");
//		
//		System.out.println(response.asPrettyString());
		
		
		
		LoginRequest loginrequest=new LoginRequest("Akshay","Akshay@123");//pojo
		AuthService authservice=new AuthService();
		Response response=authservice.login(loginrequest);
		LoginResponse loginresponse=response.as(LoginResponse.class);
		System.out.println(response.asPrettyString());
		System.out.println(loginresponse.getToken());
		
		
	}

}
