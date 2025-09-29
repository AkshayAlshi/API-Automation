package com.api.tests;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.Services.AccountServices;
import com.api.Services.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class AccountServiceTest {
	public static String Account_Payload;
	private String token;
	private Response response;
	
	
	
	@Test(description = "accountServiceTest")
    public void accountServiceTest() throws IOException {

        // Step 1: Login and get token
        AuthService authService = new AuthService();
        Response response = authService.login(new LoginRequest("Akshay", "Akshay@123"));
        LoginResponse loginResponse = response.as(LoginResponse.class);
        String token = loginResponse.getToken();
        Assert.assertNotNull(token, "Login failed, token is null!");
        System.out.println("Login Token: " + token);

        
        
        
        
        // Step 2: Verify Accounts
        AccountServices accountService = new AccountServices();
        String accountPayload = Files.readString(
                Paths.get("C:\\Eclipes Projects\\ApiAutomation_Fremawork3\\src\\test\\resources\\Accounts Service Payloads\\Account_Payload.json")
        );
        accountService.verifyAccounts(token, accountPayload);

        
        
        
        // Step 3: Get Account Info
        accountService.getAccountInfo(token);
        
        
        

        // Step 4: Get Account User Info and Assert accountNumber
        Response userInfoResp = accountService.getAccountUserInfo(token);
        Assert.assertEquals(userInfoResp.getStatusCode(), 200, "Invalid status code!");

        JsonPath jsonPath = userInfoResp.jsonPath();
        String actualAccountNumber = jsonPath.getString("[0].accountNumber");

        System.out.println("Account Number: " + actualAccountNumber);

        Assert.assertEquals(actualAccountNumber, "8784568949", "Account number mismatch!");
    }

}
