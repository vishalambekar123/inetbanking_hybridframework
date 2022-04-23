package com.vva.inetbanking.testcases;

import org.testng.annotations.Test;

import com.vva.inetbanking.pageobjects.HomePage;
import com.vva.inetbanking.pageobjects.LoginPage;
import com.vva.inetbanking.testbase.TestBase;

public class HomeTC001 extends TestBase{
	
	HomePage homepage;
	
	@Test(priority = 1)
	public void verifyLoginFunctionalityTC001() {
		
		LoginPage login = new LoginPage(driver);
		login.setusername(configdataprovider.getUserName());
		login.setpassword(configdataprovider.getPass());
		//login.clickOnLoginBtn();
		homepage = login.clickOnLoginBtn();
		
	}
	
	@Test(priority = 2, enabled = false)
	public void navigateToEditCustomerPage() {
	
		homepage.clickOnEditCustomerLink();
	}
	
	@Test(priority = 3)
	public void VerifyLogoutFunctionality() {
		homepage.clickOnLogoutLink();
	}

}
