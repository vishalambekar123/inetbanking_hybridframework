package com.vva.inetbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomerPage {

	WebDriver driver;

	public AddNewCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "name")
	@CacheLookup
	WebElement custnameTxt;

	@FindBy(xpath = "//input[@type='radio' and @value='m']")
	@CacheLookup
	WebElement maleRadioBtn;

	@FindBy(xpath = "//input[@type='radio' and @value='f']")
	@CacheLookup
	WebElement femaleRadioBtn;

	@FindBy(name = "dob")
	@CacheLookup
	WebElement custdob;

	@FindBy(name = "addr")
	@CacheLookup
	WebElement addrTxt;

	@FindBy(name = "city")
	@CacheLookup
	WebElement cityTxt;

	@FindBy(name = "state")
	@CacheLookup
	WebElement stateTxt;

	@FindBy(name = "pinno")
	@CacheLookup
	WebElement pinnoTxt;

	@FindBy(name = "telephoneno")
	@CacheLookup
	WebElement telephoneNoTxt;

	@FindBy(name = "emailid")
	@CacheLookup
	WebElement emailidTxt;

	@FindBy(name = "password")
	@CacheLookup
	WebElement passwordTxt;

	@FindBy(name = "sub")
	@CacheLookup
	WebElement subBtn;

	public void SetCustomerName(String custName) {

		custnameTxt.clear();
		custnameTxt.sendKeys(custName);
	}

	public void clickOnGenderRadioBtn(String gender) {

		if (gender.equals("Male")) {
			maleRadioBtn.click();
		} else {
			femaleRadioBtn.click();
		}
	}

	public void setDOB(String dob) {
		
		custdob.sendKeys(dob);

	}

	public void setAddr(String addr) {

		addrTxt.clear();
		addrTxt.sendKeys(addr);
	}

	public void setCity(String city) {

		cityTxt.clear();
		cityTxt.sendKeys(city);
	}

	public void setState(String state) {

		stateTxt.clear();
		stateTxt.sendKeys(state);
	}

	public void setPinno(String pincode) {
		pinnoTxt.clear();
		pinnoTxt.sendKeys(pincode);
	}

	public void setTelephono(String telenum) {

		telephoneNoTxt.clear();
		telephoneNoTxt.sendKeys(telenum);
	}

	public void setEmailid(String emailid) {

		emailidTxt.clear();
		emailidTxt.sendKeys(emailid);
	}

	public void setPassword(String password) {

		passwordTxt.clear();
		passwordTxt.sendKeys(password);
	}

	public void clickOnSubmitBtn() {

		subBtn.click();
	}
}
