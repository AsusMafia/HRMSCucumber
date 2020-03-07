package com.hrms.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.protocol.Resultset;

public class Recap {

	String dbURL = "jdbc:mysql://18.232.148.34:3306/syntaxhrm_mysql";
	String dbUserName = "syntax_hrm";
	String dbPassWord = "syntaxhrm123";

	@Test
	public void getConnection() throws SQLException {
		Connection con = DriverManager.getConnection(dbURL, dbUserName, dbPassWord);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from ohrm_skill;");

		ResultSetMetaData rsetMetaData = rs.getMetaData();

		int cols = rsetMetaData.getColumnCount();
		System.out.println(cols);

		String colName;
		for (int i = 1; i < cols; i++) {
			colName = rsetMetaData.getColumnName(i);
			System.out.println("Column names are: " + colName);

		}
		String id;
		String skills;

		while (rs.next()) {
			id = rs.getObject("id").toString();
			skills = rs.getObject("name").toString();

			System.out.println("ID: " + id);
			System.out.println("Skills: " + skills);

		}
		rs.close();
		st.close();
		con.close();
	}

}
