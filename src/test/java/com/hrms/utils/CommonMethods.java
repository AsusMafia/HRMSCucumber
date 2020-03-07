package com.hrms.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hrms.pages.PersonalDetailsPageElements;
import com.hrms.testbase.BaseClass;
import com.hrms.testbase.PageInitializer;

public class CommonMethods extends PageInitializer {

	/**
	 * This method will dismiss the alert
	 * 
	 * @throws will throw NoAlertPresentation
	 */

	public static void dismissAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		} catch (NoAlertPresentException e) {
			System.out.println("Alert has been dismissed.");
		}
	}

	/**
	 * This method will accept an alert.
	 * 
	 * @throws will throw NoAlertPresentation
	 */

	public static void acceptAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException e) {
			System.out.println("Alert has been accepted.");
		}
	}

	public static String getAlertText() {

		try {
			Alert alert = driver.switchTo().alert();
			return alert.getText();
		} catch (NoAlertPresentException e) {
			System.out.println("Alert text has been stored");
			return null;
		}

	}

	/**
	 * This method will switch to the frame
	 * 
	 * @param element
	 */

	public static void switchToFrame(String nameorID) {
		try {
			driver.switchTo().frame(nameorID);
		} catch (NoSuchFrameException e) {
			System.out.println("Frame is not present. ");
		}
	}

	/**
	 * This method will switch to the frame
	 * 
	 * @param element
	 */

	public static void switchToFrame(WebElement element) {
		try {
			driver.switchTo().frame(element);
		} catch (NoSuchFrameException e) {
			System.out.println("Frame is not present.");
		}
	}

	/**
	 * JavaScript code to click on element when the clicking can't be automated
	 * isn't working
	 * 
	 * @param webElement
	 */
	public static void jsClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	/**
	 * Method will scroll the page until the specified element is found
	 * 
	 * @param element
	 */
	public static void scrollIntoElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0]scrollIntoView(true);", element);
	}

	/**
	 * This method will scroll page down by the specified number of pixels
	 * 
	 * @param pixel
	 */
	public static void scrollDown(int pixel) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + pixel + ")");
	}

	/**
	 * This method will scroll up on the page by the amount of the specified pixel
	 * amount
	 * 
	 * @param pixel
	 */
	public static void scrollUp(int pixel) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-" + pixel + ")");
	}

	/**
	 * This method will switch to the frame
	 * 
	 * @param element
	 */

	public static void switchToFrame(int index) {
		try {
			driver.switchTo().frame(index);
		} catch (NoSuchFrameException e) {
			System.out.println("Frame is not present.");
		}
	}

	/**
	 * This method takes screenshot
	 * 
	 * @param fileName
	 */
	public static String takeScreenshot(String fileName) {

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String timeStamp = sdf.format(date.getTime());

		TakesScreenshot ts = (TakesScreenshot) driver;
		File screen = ts.getScreenshotAs(OutputType.FILE);
		String scrnshotFile = Constants.SCREENSHOTS_FILEPATH + fileName + timeStamp + ".png";

		try {
			FileUtils.copyFile(screen, new File(scrnshotFile));
		} catch (IOException e) {
			System.out.println("Cannot take the screenshot!");
		}
		return scrnshotFile;
	}

	/**
	 * This method will enter text
	 * 
	 * @param element
	 * @param value
	 */
	public static void sendText(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}

	/**
	 * This method will create an Object of WebDriverWait
	 * 
	 * @return WebDriverWait
	 */
	public static WebDriverWait getWaitObject() {
		WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_LOAD_TIME);
		return wait;
	}

	/**
	 * This method will wait until element becomes clickable
	 * 
	 * @param element
	 */
	public static void waitForClickability(WebElement element) {
		getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * This method will wait until element becomes visible
	 * 
	 * @param element
	 */
	public static void waitForVisibility(WebElement element) {
		getWaitObject().until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method will wait until element becomes invisible
	 * 
	 * @param element
	 */
	public static void waitForInvisibility(WebElement element) {
		getWaitObject().until(ExpectedConditions.invisibilityOf(element));
	}

	/**
	 * This method will click on element
	 * 
	 * @param element
	 */

	public static void click(WebElement element) {
		waitForClickability(element);
		element.click();
	}

	/**
	 * This method will select value from dropdown menu
	 * 
	 * @param element
	 * @param text
	 */

	public static void selectDropDownValue(WebElement element, String text) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();

		boolean isFound = false;
		for (WebElement option : options) {
			if (option.getText().equals(text)) {
				select.selectByVisibleText(text);
				isFound = true;
				break;
			}
		}
		if (!isFound) {
			System.out.println("Value " + text + " was not found in the dropdown");
		}
	}

	/**
	 * This method will select value from downdown
	 * 
	 * @param element
	 * @param index
	 */
	public static void selectDropDownValue(WebElement element, int index) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		boolean isFound = false;
		if (options.size() > index) {
			select.selectByIndex(index);
			isFound = true;
		}
		if (!isFound) {
			System.out.println("Value with " + index + " was not found in the dropdown");
		}
	}
	
	/**
	 * THis method will click on the radio button based on the text
	 * @param elements
	 * @param radioText
	 */
	public static void clickRadio(List<WebElement> elements, String radioText) {
		for (WebElement ele:elements) {
			if (ele.getText().equals(radioText)) {
				ele.click();
			}
		}
	}
	
	static String JSONFile;
	public static String readJSON (String fileName) {
		try {
			JSONFile = new String (Files.readAllBytes(Paths.get(fileName)));
		}catch (IOException e) {
			e.printStackTrace();
		}
		return JSONFile;
	}
	
//	public void selectGender1(String text) {
//        if (text.equals("Male")) {
//            PersonalDetailsPageElements.optMale.click();
//        }else if(text.equals("Female")) {
//            PersonalDetailsPageElements.optFemale.click();
//        }
//    }
	

}
