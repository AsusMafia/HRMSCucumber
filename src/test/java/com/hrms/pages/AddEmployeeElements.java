package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class AddEmployeeElements {
	
	@FindBy (linkText = "Add Employee")
	public WebElement add;

	@FindBy(xpath = "//input[@name='firstName']")
	public WebElement firstName;
	
	@FindBy(xpath = "//input[@name='middleName']")
	public WebElement middleName;

	@FindBy(xpath = "//input[@name='lastName']")
	public WebElement lastName;

	@FindBy(xpath = "//input[@name='employeeId']")
	public WebElement empID;
	
	@FindBy (css = "input#personal_txtEmployeeId")
	public WebElement addedEmpID;

	@FindBy(id = "chkLogin")
	public WebElement createLoginDetails;
	
	@FindBy(id = "user_name")
	public WebElement username;
	
	@FindBy(id = "user_password")
	public WebElement userPassword;
	
	@FindBy(id = "re_password")
	public WebElement confirmUserPassword;
	
	@FindBy(css = "input#btnSave")
	public WebElement submit;

	@FindBy(xpath = "//div[@id='profile-pic']/h1")
	public WebElement name;
	
	@FindBy(xpath = "//span[@for='firstName']")
	public WebElement noFirNameErr;
	
	@FindBy (xpath = "//span[@for='lastName']")
	public WebElement noLastNameErr;

	public AddEmployeeElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
}
