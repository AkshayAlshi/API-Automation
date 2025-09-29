package com.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.Services.AuthService;
import com.api.Services.TrasactionService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;


@Listeners(com.api.listners.TestListeners.class)
public class TrasactionServiceTest {

	public String token;
	private final TrasactionService TS = new TrasactionService();

	@BeforeClass 
	public void authsetup() {
		
		 // Step 1: Login and get token
        AuthService authService = new AuthService();
        Response response = authService.login(new LoginRequest("Akshay", "Akshay@123"));
        LoginResponse loginResponse = response.as(LoginResponse.class);
        token = loginResponse.getToken();
        Assert.assertNotNull(token, "Login failed, token is null!");
        System.out.println("Login Token: " + token);
        
        
	}
	
	
	@Test(priority=1 , description = "verifyDepositTest", groups = {"TransactionService"})
	public void verifyDepositTest() throws IOException {
		
		String accountDeposit = Files.readString(
        Paths.get("C:\\Eclipes Projects\\ApiAutomation_Fremawork3\\src\\test\\resources\\Accounts Service Payloads\\Account_Deposit.json"));
		
		
		TS.verifyDeposit(accountDeposit, token);
	}
	
	
	@Test (priority=2 , description = "verifyTransactionHistoryTest", groups = {"TransactionService"})
	public void verifyTransactionHistoryTest() {
		
		TS.verifyTransactionHistory(token);
		
		
	}
	
	@Test(priority=3 , description = "verifyTransferfundTest", groups = {"TransactionService"})
	public void verifyTransferfundTest() throws IOException {
		
		String Transferfundpayload = Files.readString(
        Paths.get("C:\\Eclipes Projects\\ApiAutomation_Fremawork3\\src\\test\\resources\\Accounts Service Payloads\\TransferFund.json"));
		
		
		TS.verifyTransferfund(Transferfundpayload, token);
	}
	
	
	
	@Test(priority=4 , description = "verifyTransferfundInitiateTest", groups = {"TransactionService"})
	public void verifyTransferFundInitiateTest() throws IOException {
		
		String TransferInitiatepayload = Files.readString(
        Paths.get("C:\\Eclipes Projects\\ApiAutomation_Fremawork3\\src\\test\\resources\\Accounts Service Payloads\\TrasnferInitiate.json"));
		
		
		TS.verifyTransferfundInitiate(TransferInitiatepayload, token);
	}
	
	
	
	@Test(priority=5 , description = "verifyverifyWithdowTest", groups = {"TransactionService"})
	public void verifyverifyWithdowTest() throws IOException {
		
		String TransferInitiatepayload = Files.readString(
        Paths.get("C:\\Eclipes Projects\\ApiAutomation_Fremawork3\\src\\test\\resources\\Accounts Service Payloads\\Withdraw.json"));
		
		
		TS.verifyWithdow(TransferInitiatepayload, token);
	}
	
}
