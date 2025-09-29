package com.api.Services;

import com.api.base.BaseService;

import io.restassured.response.Response;

public class AccountServices  extends BaseService{

	
	private final static String BASE_PATH="/api/accounts";
	
	public Response verifyAccounts(String token,String payload) {
		setAuthToken(token);
		return postRequest(payload,BASE_PATH);	
	}
	
	public Response getAccountInfo(String token) {
		setAuthToken(token);
		return getRequest(BASE_PATH+"/1234567890");
		
	}
	
	public Response getAccountUserInfo(String token) {
		setAuthToken(token);
		return getRequest(BASE_PATH+"/user");
		
	}
	
	
	
	
}
