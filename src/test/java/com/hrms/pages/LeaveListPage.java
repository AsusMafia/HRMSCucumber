package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class LeaveListPage {
	
	@FindBy (css = "a.toggle.tiptip")
	public WebElement leaveListLable;
	
	public LeaveListPage() {
		PageFactory.initElements(BaseClass.driver, this);
	}

}
