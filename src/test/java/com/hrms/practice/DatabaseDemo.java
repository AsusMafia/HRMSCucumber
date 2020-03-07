package com.hrms.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import org.junit.runners.model.Statement;
import org.testng.annotations.Test;

public class DatabaseDemo {

	String databaseURL = "jdbc:mysql://18.232.148.34:3306/syntaxhrm_mysql";
	String port = "3306";
	String databaseName = "syntaxhrm_mysql";
	String databseUserName = "syntax_hrm";
	String databasePassword = "syntaxhrm123";

	@Test
	public void database() throws SQLException, ClassNotFoundException {

		// This creates a connection
		// Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(databaseURL, databseUserName, databasePassword);

		System.out.println("The connection is " + conn);

		/*
		 * The createStatement() method of Connection interface is used to create
		 * statement. The object of statement is responsible to execute queries with the
		 * database. The Statement interface provides methods to execute queries with the 
		 * database.
		 */
		Statement stmt = conn.createStatement();
		
		//Execute query and store the result
		ResultSet rSet=stmt.executeQuery("select * from hs_hr_employees");
		System.out.println("Result is "+rSet);
		
		rSet.next();			//Next clear line
		String firstRow = rSet.getString("emp_number");
		System.out.println(firstRow);
		
		rSet.next();
		String secondRow = rSet.getString("emp_number");
		System.out.println(secondRow);
		
		rSet.next();			//Next clear line
		String columnData = rSet.getString("emp_firstname");
		System.out.println(columnData);
		
		
		
		rSet.next();			
		columnData = rSet.getString(3);
		System.out.println(columnData);
		
		System.out.println("How to print all values using while loop");
		while (rSet.next()) {
			columnData = rSet.getString("emp_lastname");
			if (columnData.endsWith("z")) {
				System.out.println(columnData);
			}
		
		}
		

	}

}
