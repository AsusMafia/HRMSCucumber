package com.hrms.testbase;

import com.hrms.pages.AddEmployeeElements;
import com.hrms.pages.DashBoardPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.pages.PersonalDetailsPageElements;
import com.hrms.utils.CommonMethods;

public class PageInitializer extends BaseClass{
	public static LoginPageElements login;
	public static DashBoardPageElements dashboard;
	public static AddEmployeeElements addEmp;
	public static PersonalDetailsPageElements pdetails;
	public static CommonMethods common;
	
	public static void initializeAll() {
		login = new LoginPageElements();
		dashboard = new DashBoardPageElements();
		addEmp = new AddEmployeeElements();
		pdetails = new PersonalDetailsPageElements();
		common = new CommonMethods();
	}

}
