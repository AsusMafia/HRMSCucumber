package com.hrms.pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.hrms.testbase.BaseClass;

public class LoginPage extends BaseClass {

	public WebElement username = driver.findElement(By.xpath("//input[@id='txtUsername']"));
	public WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
	public WebElement loginBtn = driver.findElement(By.xpath("//input[@id='btnLogin']"));

	public String errorMessage() {
		WebElement errMsg;
		try {
			errMsg = driver.findElement(By.xpath("//span[@id='spanMessage']"));
			return errMsg.getText();
		} catch (NoSuchElementException e) {
			System.out.println("Error message is not found");
			return null;
		}
	}
	

}
