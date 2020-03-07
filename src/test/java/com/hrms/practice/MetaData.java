package com.hrms.practice;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class MetaData {

	String databaseURL = "jdbc:mysql://18.232.148.34:3306/syntaxhrm_mysql";
	String port = "3306";
	String databaseName = "syntaxhrm_mysql";
	String databseUserName = "syntax_hrm";
	String databasePassword = "syntaxhrm123";

	@Test
	public void getMetaData() throws SQLException {

		Connection conn = DriverManager.getConnection(databaseURL, databseUserName, databasePassword);
		DatabaseMetaData dbMetaData = conn.getMetaData();
		String dbName = dbMetaData.getDatabaseProductName();
		String dbVersion = dbMetaData.getDatabaseProductVersion();

		System.out.println("The name of the database is " + dbName);
		System.out.println("The databse version is " + dbVersion);

		Statement stmnt = conn.createStatement();
		ResultSet rSet = stmnt.executeQuery("SELECT * FROM hs_hr_employees where employee_id = 4353;");
		ResultSetMetaData resultData = rSet.getMetaData();
		int cols = resultData.getColumnCount();
		System.out.println("The number of columns in the database is " + cols);

		String colName = resultData.getColumnClassName(1);
		System.out.println("The name of all columns are " + colName);

		for (int i = 1; i < cols; i++) {
			colName = resultData.getColumnName(i);
			System.out.println(colName);
		}

	}

}
