package com.api.Services;

import com.api.base.BaseService;

public class AdminService extends BaseService {

	
	private final static String BASE_PATH="/api/admin";
	
	public void getAdminAccount(String token) {
		setAuthToken(token);
		getRequest(BASE_PATH+"");
	}
	
	
}
