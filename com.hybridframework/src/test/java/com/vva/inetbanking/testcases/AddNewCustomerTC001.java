package com.vva.inetbanking.testcases;

import org.testng.annotations.Test;

import com.vva.inetbanking.pageobjects.AddNewCustomerPage;
import com.vva.inetbanking.pageobjects.HomePage;
import com.vva.inetbanking.pageobjects.LoginPage;
import com.vva.inetbanking.testbase.TestBase;
import com.vva.inetbanking.utility.Helper;

public class AddNewCustomerTC001 extends TestBase {

	@Test
	public void addNewCustomerTest() throws InterruptedException {

		LoginPage login = new LoginPage(driver);
		login.setusername(configdataprovider.getUserName());
		login.setpassword(configdataprovider.getPass());
		HomePage homepage = login.clickOnLoginBtn();

		Thread.sleep(3000);

		AddNewCustomerPage addcust = homepage.clickOnNewCustomerLink();

		addcust.SetCustomerName("abcd");
		addcust.clickOnGenderRadioBtn("Male");

		addcust.setDOB("12");
		Thread.sleep(2000);
		addcust.setDOB("05");
		Thread.sleep(2000);
		addcust.setDOB("2021");

		addcust.setAddr("Hudco Aurangabad");
		addcust.setCity("Aurangabad");
		addcust.setState("Maharashtra");

		addcust.setPinno("431003");
		addcust.setTelephono("9876543210");

		String randomString = Helper.getRandomString();

		addcust.setEmailid(randomString + "@gamil.com");

		addcust.setPassword("abcd@12345");
		addcust.clickOnSubmitBtn();
	}

}
