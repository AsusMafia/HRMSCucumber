package com.hrms.API.steps.practice;

import cucumber.api.java.en.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

import org.junit.Assert;

import static org.hamcrest.Matchers.equalTo;

import com.hrms.utils.APIConstants;

public class GETOneEmployeeAPISteps {
	
	private static RequestSpecification request;
	private Response response;
	
	@Given("user calls getOneEmployee API")
	public void user_calls_getOneEmployee_API() {
	   request =  given().header("Content-Type", "application/json").header("Authorization", SyntaxAPIAuthenticationSteps.Token)
	    .formParam("employee_id", POSTCreateEmployeeAPI.employee_id);
	}

	@When("User retrieves response for getOneEployee API")
	public void user_retrieves_response_for_getOneEployee_API() {
	   response =  request.when().get(APIConstants.GET_ONE_EMPLOYEE_URI);
	   response.prettyPrint();
	   
	}

	@Then("status code is {int} for getOneEmployee API")
	public void status_code_is_for_getOneEmployee_API(int int1) {
	   
		response.then().assertThat().statusCode(int1);
		
	}

	@Then("user validates created employee exists")
	public void user_validates_created_employee_exists() {
		response.then().body("employee[0].employee_id", equalTo(POSTCreateEmployeeAPI.employee_id));
		
		JsonPath jsonPathEvaluator = response.jsonPath();
		String actualEmployeeID = jsonPathEvaluator.getString("employee[0].employee_id");
		System.out.println("Actual Employee ID is:" + actualEmployeeID);
		Assert.assertEquals("Verifying Employee IDs ", POSTCreateEmployeeAPI.employee_id, actualEmployeeID);
		
		try {
			Assert.assertEquals("Verifying Employee IDs ", POSTCreateEmployeeAPI.employee_id, actualEmployeeID);
		}catch (AssertionError e) {
			System.out.println("Employee ID's Don't Match");
		}
		System.out.println("Employee ID's Match");
	    
	}
}
