package com.hrms.utils;

public class APIConstants {

	public static final String CREATE_EMPLOYEE_URI = "http://18.232.148.34/syntaxapi/api/CreateEmployee.php";

	public static final String GENERATE_TOKEN = "http://18.232.148.34/syntaxapi/api/generateToken.php";

	public static final String CREATE_EMPLOYEE_JSON = "src/test/resources/JSONFiles/createEmployee.json";

	public static final String GENERATE_TOKEN_JSON = "src/test/resources/JSONFiles/generateToken.json";

	public static final String GET_ALL_EMPLOYEES_URI = "http://18.232.148.34/syntaxapi/api/getAllEmployees.php";
	
	public static final String GET_ONE_EMPLOYEE_URI = "http://18.232.148.34/syntaxapi/api/getOneEmployee.php";
	
	public static final String GET_ALL_JOBTITLES_URI = "http://18.232.148.34/syntaxapi/api/jobTitle.php";
	
	public static final String GET_ALL_EMPLOYEE_STATUS_URI = "http://18.232.148.34/syntaxapi/apiemployeeStatus.php";

	public static final String UPDATE_EMPLOYEE_URI = "http://18.232.148.34/syntaxapi/api/updateEmployee.php";
	
	public static final String DELETE_EMPLOYEE_URI = "http://18.232.148.34/syntaxapi/api/deleteEmployee.php";

	public static final String STORE_JSON = System.getProperty("user.dir")
            + "/src/test/resources/JSONFiles/store.json";
}
