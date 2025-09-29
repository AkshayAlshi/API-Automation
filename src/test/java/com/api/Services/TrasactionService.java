package com.api.Services;

import com.api.base.BaseService;

import io.restassured.response.Response;

public class TrasactionService extends BaseService{

	
	private final static String BASE_PATH="/api/transactions";
	
	
	public Response verifyDeposit(String payload,String token) {
		setAuthToken(token);
		return postRequest(payload,BASE_PATH+"/deposit");	
	}
	
	
	public Response verifyTransactionHistory(String token) {
		setAuthToken(token);
		return getRequest(BASE_PATH+"history?accountNumber=1234567890&page=1&size=10");
	}
	
	
	public Response verifyTransferfund(String token,String payload) {
		setAuthToken(token);
		return postRequest(payload,BASE_PATH+"/transfer");
	}
	
	
	public Response verifyTransferfundInitiate(String token,String payload) {
		setAuthToken(token);
		return postRequest(payload,BASE_PATH+"/initiate");
	}
	
	
	public Response verifyWithdow(String token,String payload) {
		setAuthToken(token);
		return postRequest(payload,BASE_PATH+"/initiate");
	}
	
	
	
	
	
}
