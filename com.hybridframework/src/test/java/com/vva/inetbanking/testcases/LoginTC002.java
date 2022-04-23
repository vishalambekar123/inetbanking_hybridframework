package com.vva.inetbanking.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vva.inetbanking.pageobjects.LoginPage;
import com.vva.inetbanking.testbase.TestBase;

//When you will Run VerifyLoginFunctionalityDDTest case change @BeforeTest & @AfterTest to
//@BeforeMethod & @AfterMethod in TestBase class

public class LoginTC002 extends TestBase {

	@DataProvider
	public Object[][] getData() {
		
		return excelDataProvider.getExcelTestData("DDt_Login");
		
	}
	
	@Test(dataProvider = "getData")
	public void VerifyLoginFunctionalityDDTest(Object username, Object password) {

		LoginPage login = new LoginPage(driver);
		login.setusername((String)username);
		login.setpassword((String)password);
		
		login.clickOnLoginBtn();
	
	
	
//	@Test
//	public void verifyLoginFunctionalityTC002() {
//		
//		LoginPage login = new LoginPage(driver);
//		login.setusername(excelDataProvider.getStringCellValue("login", 1, 0));
//		login.setpassword(excelDataProvider.getStringCellValue("login", 1, 1));
//		login.clickOnLoginBtn();
		
	
	}
	
}
