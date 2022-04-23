package com.vva.inetbanking.testcases;

import org.testng.annotations.Test;

import com.vva.inetbanking.pageobjects.LoginPage;
import com.vva.inetbanking.testbase.TestBase;
import com.vva.inetbanking.utility.Helper;

public class LoginTC001 extends TestBase {

	
//	@Test
//	public void verifyLoginFunctionalityTC001() {
//		
//		LoginPage login = new LoginPage(driver);
//		login.setusername("mngr395244");
//		login.setpassword("YrYbEjY");
//		login.clickOnLoginBtn();
//		
//	}
	@Test
	public void verifyLoginFunctionalityTC001() {
		
		extentTest =  extentReport.createTest("Login Functinality Test");
		LoginPage login = new LoginPage(driver);
		login.setusername(configdataprovider.getUserName());
		login.setpassword(configdataprovider.getPass());
		login.clickOnLoginBtn();
				
	}
	
}
