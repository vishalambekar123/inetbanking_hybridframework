package com.vva.inetbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.vva.inetbanking.utility.Helper;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Login Page Object Repository
	@FindBy(name = "uid")
	WebElement txt_username;

	@FindBy(name = "password")
	WebElement txt_password;

	@FindBy(name = "btnLogin")
	WebElement loginBtn;

	public void setusername(String username) {

		try {
			txt_username.clear();
			txt_username.sendKeys(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

	public void setpassword(String pass) {

		try {
			txt_password.clear();
			txt_password.sendKeys(pass);
		} catch (Exception e) {

			e.printStackTrace();
		}
		

	}

	public HomePage clickOnLoginBtn() {
		
		try {
			loginBtn.click();
			String exp_home_title = "Guru99 Bank Manager HomePage";
			String act_home_title = driver.getTitle();
			if(exp_home_title.equals(act_home_title)) {
				Assert.assertTrue(true);
				Helper.capturescreenshot(driver);
				return new HomePage(driver);
			}
			else {
				if(Helper.isAlertPresent(driver)) {
					driver.switchTo().alert().accept();
				}
				Assert.assertTrue(false);
				return null;
			}
			
			
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}
		
	}
}
