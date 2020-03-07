package com.hrms.steps;


import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.support.ui.Select;

import com.hrms.pages.AddEmployeeElements;
import com.hrms.pages.DashBoardPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.pages.PersonalDetailsPageElements;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;

public class AddEmployeeSteps extends CommonMethods {


	String empId;
	String addedEmpId;

	String fullName;

	@Given("I am logged into HRMS")
	public void i_am_logged_into_HRMS() {

		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
	}

	@Given("I navigated to Add Employee Page")
	public void i_navigated_to_Add_Employee_Page() {
		// DashBoardPageElements dashboard = new DashBoardPageElements();
		dashboard.navigateToAddEmployee();
	}


	
	@When("I add {string} {string} and {string}")
	public void i_add_an(String fName, String mName, String lName) {
		sendText(addEmp.firstName, fName);
		sendText(addEmp.middleName, mName);
		sendText(addEmp.lastName, lName);
		fullName = addEmp.firstName.getText() + " " + addEmp.middleName.getText() + " " + addEmp.lastName.getText();
		empId = addEmp.empID.getText();
	}
	
	@When("I add {string}, {string} and {string}")
	public void i_add_and(String fName, String mName, String lName) {
		sendText(addEmp.firstName, fName);
		sendText(addEmp.middleName, mName);
		sendText(addEmp.lastName, lName);
		fullName = addEmp.firstName.getText() + " " + addEmp.middleName.getText() + " " + addEmp.lastName.getText();
		empId = addEmp.empID.getText();
	}

	@When("I click Save")
	public void i_click_Save() throws InterruptedException {

		jsClick(addEmp.submit);
	//	addedEmpId = addEmp.addedEmpID.getText();
	}

	@Then("I see Employee has been succesfully added")
	public void i_see_Employee_has_been_succesfully_added() {
		// PersonalDetailsPageElements pdetails = new PersonalDetailsPageElements();
		Assert.assertEquals("Employee is NOT being added", pdetails.empId.getText(), addedEmpId);
	}

	@Then("I see Employee with {string} is displayed")
	public void i_see_Employee_with_is_displayed(String addedFullName) {
		Assert.assertEquals(fullName, pdetails.addedFullName);

	}

	@When("I delete employee id")
	public void i_delete_employee_id() {
		addEmp.empID.clear();
	}

	@Then("I see required error message next to the first and last name")
	public void i_see_required_error_message_next_to_the_first_and_last_name() {
		boolean nofirstName = addEmp.noFirNameErr.isDisplayed();
		boolean noLastName = addEmp.noLastNameErr.isDisplayed();

		assertTrue(nofirstName);
		assertTrue(noLastName);
	}

	@When("I click on create login checkbox")
	public void i_click_on_create_login_checkbox() {

		addEmp.createLoginDetails.click();

	}

	@When("I add {string}")
	public void i_add(String John) {
		sendText(addEmp.firstName, John);
	}

	@When("I enter username, password and confirm password")
	public void i_enter_username_password_and_confirm_password() {
		sendText(addEmp.username, "Abebe");
		sendText(addEmp.userPassword, "bekele1");
		sendText(addEmp.confirmUserPassword, "bekele1");
	}

	@When("I enter employee details")
	public void i_enter_employee_details(DataTable empDetails) {
		
		List<Map<String, String>> empDetailList = empDetails.asMaps();

		for (Map<String, String> map : empDetailList) {
			sendText(addEmp.firstName, map.get("FirstName"));
			sendText(addEmp.middleName, map.get("MiddleName"));
			sendText(addEmp.lastName, map.get("LastName"));
		}
	}

	@When("I click on Edit")
	public void i_click_on_Edit() {
		pdetails=new PersonalDetailsPageElements();
		jsClick(pdetails.edit_saveBtn);
	}

	@Then("I am able to modify Employee Details")
	public void i_am_able_to_modify_Employee_Details(DataTable editEmpDetails) throws InterruptedException {
		Select maritalStatus = new Select(pdetails.maritalStatus);
		Select nationality = new Select(pdetails.nationality);

		List<Map<String, String>> editList = editEmpDetails.asMaps();
		
		for (Map<String, String> editable : editList) {
			jsClick(pdetails.edit_saveBtn);
			sendText(pdetails.licenNo, editable.get("DriverLicense"));
			sendText(pdetails.licExpDate, editable.get("ExpirationDate"));
			sendText(pdetails.SSN, editable.get("SSN"));
			sendText(pdetails.SIN, editable.get("SIN"));
			
			clickRadio(pdetails.gender, editable.get("Gender"));
			//selectGender1(editable.get("Gender").toString());
			
			Thread.sleep(3000);
			selectDropDownValue(pdetails.maritalStatus, editable.get("MaritalStatus"));
			selectDropDownValue(pdetails.nationality, editable.get("Nationality"));
			sendText(pdetails.DOB, editable.get("DOB"));

			jsClick(pdetails.edit_saveBtn);
		}

	}
}