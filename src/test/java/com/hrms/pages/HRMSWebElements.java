package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;

public class HRMSWebElements extends CommonMethods{
	
	@FindBy(xpath ="//input[@id='txtUsername']")
	public WebElement userName;
	
	@FindBy (name ="txtPassword")
	public WebElement passWord;
	
	@FindBy (xpath = "//div[@id='divLogo']/img")
	public WebElement logo;
	
	@FindBy (id = "btnLogin")
	public WebElement submit;
	
	@FindBy (css = "span#spanMessage")
	public WebElement spanMessage;
	
	public HRMSWebElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	public void login(String uid, String pwd) {
		sendText(userName, uid);
		sendText(passWord, pwd);
		click(submit);
	}
	
	
}
