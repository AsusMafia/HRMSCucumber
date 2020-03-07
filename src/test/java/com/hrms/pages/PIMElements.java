package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class PIMElements {
	
	@FindBy (linkText = "Add Employee")
	public WebElement addEmployee;
	
	public PIMElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}

}
