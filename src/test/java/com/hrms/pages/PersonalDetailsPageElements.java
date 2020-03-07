package com.hrms.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class PersonalDetailsPageElements {
	@FindBy(id="empPic")
	public WebElement empPicture;
	
	@FindBy(xpath="//div[@id='profile-pic']/h1")
	public WebElement addedFullName;
	
	@FindBy(id="personal_txtEmployeeId")
	public WebElement empId;
	
	@FindBy(id = "btnSave")
	public WebElement edit_saveBtn;
	
	@FindBy (id = "personal_txtEmployeeId")
	public WebElement addedEmpID;
	
	//license, expiration date, ssn, sin, Gender, marital status, Nationality, DOB
	
	@FindBy (id = "personal_txtLicenNo")
	public WebElement licenNo;
	
	@FindBy (id = "personal_txtLicExpDate")
	public WebElement licExpDate;
	
	@FindBy (id = "personal_txtNICNo")
	public WebElement SSN;
	
	@FindBy (id = "personal_txtSINNo")
	public WebElement SIN;
	
	@FindBy (xpath = "//input[@name='personal[optGender]']")
	public List<WebElement> gender;
	
	@FindBy (id = "personal_cmbMarital")
	public WebElement maritalStatus;
	
	@FindBy (id = "personal_cmbNation")
	public WebElement nationality;
	
	@FindBy (id = "personal_DOB")
	public WebElement DOB;
	
	@FindBy (xpath = "//input[@name='personal[optGender']")
	public static WebElement optMale;
	
	@FindBy (xpath = "//label[@for='personal_optGender_2']")
	public static WebElement optFemale;
	
	public PersonalDetailsPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	
//	public void selectGender (String text) {
//		if (text.equalsIgnoreCase("Male")) {
//			optMale.click();
//		}else if (text.equalsIgnoreCase("Female")) {
//			optFemale.click();
//		}
//	}
}