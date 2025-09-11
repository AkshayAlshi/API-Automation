package com.api.base;

import  io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

import com.api.models.request.LoginRequest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class BaseService { //Wrapper for rest Assured
	
	//BASE URI
	//CREATING REQUEST
	//HANDLING RESPONSE
	
	private final static String BASE_URI="http://64.227.160.186:8080";
	private RequestSpecification requestspecification;
	
	
	public BaseService() {
		requestspecification= given().baseUri(BASE_URI);
		
		
	}
	
	protected Response postRequest(Object payload,String endpoint) {
		return requestspecification.contentType(ContentType.JSON).body(payload).post(endpoint);
	}
	
	

}
