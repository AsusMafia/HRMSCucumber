package com.hrms.practice;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.mysql.cj.protocol.x.ResultMessageListener;

public class StoringDataFromDB {
	
	String dbURL = "jdbc:mysql://18.232.148.34:3306/syntaxhrm_mysql";
	String dbUserName = "syntax_hrm";
	String dbPassWord = "syntaxhrm123";
	
	@Test
	public void getAndStoreEnhanced() throws SQLException {
	Connection con = DriverManager.getConnection(dbURL, dbUserName, dbPassWord);
	Statement st = con.createStatement();
	ResultSet rs = st.executeQuery("select * from ohrm_skill;");
	
	ResultSetMetaData rSetMetaData = rs.getMetaData();
	
	List<Map<String, String>> listData = new ArrayList<>();
	Map<String, String> rowMap;
	
	while (rs.next()) {
		rowMap = new LinkedHashMap<>();
		
		for (int i = 1; i < rSetMetaData.getColumnCount(); i++) {
			rowMap.put(rSetMetaData.getColumnName(i), rs.getObject(i).toString());
		}
		
		listData.add(rowMap);
	}
	
	System.out.println(listData);
	
	
	}
}
