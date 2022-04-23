package com.vva.inetbanking.utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {

	public static String capturescreenshot(WebDriver driver) {

		String screenpath = System
				.getProperty("user.dir") + "/Screenshot//inetbanking_" + getCurrentDateTime() + ".png";

		try {
			File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(screenpath));

			System.out.println("Screenshot Captured");
			return screenpath;
		} catch (Exception e) {
			System.out.println("Not able to Capture Screenshot");
			return null;
		}

	}

	public static String getCurrentDateTime() {
		SimpleDateFormat customDate = new SimpleDateFormat("MM-DD-YYYY-HH-mm-ss");
		Date currentDate = new Date();
		return customDate.format(currentDate);
	}

	public static boolean isAlertPresent(WebDriver driver) {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	public static String getRandomString() {

		return RandomStringUtils.randomAlphabetic(6);
	}

}
