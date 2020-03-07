package com.hrms.steps;

import org.junit.Assert;

import com.hrms.pages.LoginPageElements;
import com.hrms.utils.CommonMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps extends CommonMethods {

	@Given("I open browser and navigated to the HRMS")
	public void i_open_browser_and_navigated_to_the_HRMS() {

		setUp();
	}

	@When("I entered valid username and valid password")
	public void i_entered_valid_username_and_valid_password() {

		login = new LoginPageElements();
		sendText(login.username, "Admin");
		sendText(login.password, "Syntax@123");
	}

	@When("I click on login button")
	public void i_click_on_login_button() {
		login = new LoginPageElements();
		click(login.loginBtn);
	}

	@Then("I successfully logged in")
	public void i_successfully_logged_in() {

	}

	@When("I entered valid username and invalid password")
	public void i_entered_valid_username_and_invalid_password() {
		login = new LoginPageElements();
		sendText(login.username, "Admin");
		sendText(login.password, "sdfwdf");

	}
	
	
	

	@Then("I see error message")
	public void i_see_error_message() {
		boolean error = login.errorMsg.isDisplayed();
		Assert.assertTrue("Error message is not displayed", error);
	}
	
	@When("I enter {string} and {string}")
	public void i_add_and(String Username, String Password) {
		LoginPageElements login = new LoginPageElements();
		sendText(login.username, Username);
		sendText(login.password, Password);
		
	}

	@Then("I see {string}")
	public void i_see_error_message(String ErrorMessage) {
		
		String error = login.errorMsg.getText();
		Assert.assertEquals(error, login.errorMsg);
	}
	
	@Then("I close the browser")
	public void i_close_the_browser() {
	   tearDown();
	}

}
