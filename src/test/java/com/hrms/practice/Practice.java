package com.hrms.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import java.sql.ResultSet;

import com.mysql.cj.protocol.Resultset;

public class Practice {

	// Create connection to db and retrieve all job titles and store them inside
	// arraylist

	String databaseURL = "jdbc:mysql://18.232.148.34:3306/syntaxhrm_mysql";
	String port = "3306";
	String databaseName = "syntaxhrm_mysql";
	String databseUserName = "syntax_hrm";
	String databasePassword = "syntaxhrm123";

	@Test
	public void allJobTitles() throws SQLException {
		Connection connect = DriverManager.getConnection(databaseURL, databseUserName, databasePassword);

		Statement stmt = connect.createStatement();
		ResultSet rSet = stmt.executeQuery("select * from ohrm_job_title");

		String title;

		List<String> jobTitleList = new ArrayList();
		while (rSet.next()) {
			title = rSet.getString(2);
			jobTitleList.add(title);
		}

		for (String table : jobTitleList) {
			System.out.println(table);
		}
		rSet.close();
		stmt.close();
		connect.close();
	}

}
