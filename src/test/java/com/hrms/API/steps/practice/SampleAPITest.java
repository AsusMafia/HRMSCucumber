package com.hrms.API.steps.practice;

import org.junit.Assert;
import org.testng.annotations.Test;

import gherkin.deps.com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;


import static io.restassured.RestAssured.*;

public class SampleAPITest {
	
	//@Test
	public void getAllJobTitles() {
		
		Response response = RestAssured.given().contentType("application/json").header("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI0NzExNDUsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4MjU4NjM0NSwidXNlcklkIjoiMjQxIn0.hc08po8pfJ7rAK6c2ejPqQ6Cr_YUmsVZ9fxhAYGHfaQ")
		.when().get("http://18.232.148.34/syntaxapi/api/jobTitle.php");
		response.prettyPrint();
		
		
		int actualResponseCode = response.getStatusCode();
		System.out.println(actualResponseCode);
		
	}
	
//	@Test
	public void getEmployeeStatus() {
		
		Response response2 = RestAssured.given().contentType("application/json").header("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI0NzExNDUsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4MjU4NjM0NSwidXNlcklkIjoiMjQxIn0.hc08po8pfJ7rAK6c2ejPqQ6Cr_YUmsVZ9fxhAYGHfaQ")
				.when().get("http://18.232.148.34/syntaxapi/api/employeeStatus.php");
		response2.prettyPrint();
		int actualResponseCode = response2.getStatusCode();
		System.out.println(actualResponseCode);
	}
	
//	@Test
	public void getOneEmployee() {
		Response response3 = RestAssured.given().formParam("employee_id", "3454564").contentType("application/json").header("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI0NzExNDUsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4MjU4NjM0NSwidXNlcklkIjoiMjQxIn0.hc08po8pfJ7rAK6c2ejPqQ6Cr_YUmsVZ9fxhAYGHfaQ")
		.when().get("http://18.232.148.34/syntaxapi/api/getOneEmployee.php");
		response3.prettyPrint();
		
	}
	
	@Test
	public void createEmployee() {
		Response response4 = RestAssured.given().contentType("application/json").header("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI5MzI1NDAsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4MzA0Nzc0MCwidXNlcklkIjoiMjQxIn0.jE3EYvM0L55vkmnw9bhT8mUE2LLlWkNG8JsyfOox7Rg")
		.body("{\n    \"emp_firstname\": \"Kalis\",\n    \"emp_lastname\": \"Bresada\",\n    \"Y\": \"Senior\",\n    \"emp_gender\": \"1\",\n    \"emp_birthday\": \"1965-02-23\",\n    \"emp_status\": \"Worker\",\n    \"emp_job_title\": \"Cloud Consultant\"\n}")
//		.param("emp_firstname", "Jackson")
//		.param("emp_lastname", "Marcus")
//		.param("emp_middle_name", "H")
//		.param("emp_birthday", "1980-02-03")
//		.param("emp_gender", "1")
//		.param("emp_job_title", "Cloud Architect")
//		.param("emp_status", "Independent contractor")
		.post("http://18.232.148.34/syntaxapi/api/createEmployee.php");
		
		
		
		
		response4.prettyPrint();
		int statusCode4 = response4.getStatusCode();
		System.out.println(statusCode4);
		Assert.assertEquals(200, statusCode4);
	
   
	}
	
	

}
