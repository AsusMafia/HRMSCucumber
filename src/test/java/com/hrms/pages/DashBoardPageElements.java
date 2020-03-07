package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;

public class DashBoardPageElements extends CommonMethods{
	
	@FindBy (linkText = "Leave")
	public WebElement Leave;
	
	@FindBy (linkText = "Leave List")
	public WebElement LeaveList;
	
	@FindBy (linkText = "PIM")
	public WebElement PIM;
	
	@FindBy (linkText = "Add Employee")
	public WebElement addEmployee;
	
	@FindBy(id = "welcome")
	public WebElement welcomeLnk;
	
	
	public DashBoardPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	public void navigateToLeaveList() {
		jsClick(Leave);
		jsClick(LeaveList);
		
	}
	
	public void navigateToAddEmployee() {
		jsClick(PIM);
		jsClick(addEmployee);
		
	}
	
	

}
