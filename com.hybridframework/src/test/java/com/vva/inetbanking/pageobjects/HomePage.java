package com.vva.inetbanking.pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vva.inetbanking.utility.Helper;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// object repository for Home Page

	@FindBy(linkText = "New Customer")
	WebElement newCustomer_Link;

	@FindBy(linkText = "Edit Customer")
	WebElement editCustomer_Link;

	@FindBy(linkText = "Delete Customer")
	WebElement deleteCustomer_Link;

	@FindBy(linkText = "New Account")
	WebElement newAccount_Link;

	@FindBy(linkText = "Log out")
	WebElement logout_Link;

	public AddNewCustomerPage clickOnNewCustomerLink() {
		try {
			newCustomer_Link.click();
			Thread.sleep(5000);
//			WebElement frame1 = driver.findElement(By.id("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0"));
			driver.switchTo().frame(driver.findElement(By.id("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0")));
//			WebElement frame2 = driver.findElement(By.id("ad_iframe"));
			driver.switchTo().frame(driver.findElement(By.id("ad_iframe")));

			driver.findElement(By.xpath("//div[@id='dismiss-button']/div/span")).click();
			driver.switchTo().defaultContent();
			
			return new AddNewCustomerPage(driver);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public EditCustomerPage clickOnEditCustomerLink() {
		try {
			editCustomer_Link.click();
			return new EditCustomerPage();
		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}

	}

	public DeleteCustomerPage clickOnDeleteCustomerLink() {
		try {
			deleteCustomer_Link.click();
			return new DeleteCustomerPage();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public NewAccountPage clickOnNewAccountLink() {
		try {
			newAccount_Link.click();
			return new NewAccountPage();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public void clickOnLogoutLink() {
		try {
			logout_Link.click();
			if (Helper.isAlertPresent(driver)) {
				Alert alert = driver.switchTo().alert();
				System.out.println(alert.getText());
				alert.accept();
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

	}
}
