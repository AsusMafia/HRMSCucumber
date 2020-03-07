package com.hrms.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DbUtils {

	private static Connection conn;
	private static Statement st;
	private static ResultSet rset;

	private static List<Map<String, String>> listData;

	/**
	 * Method to create a connection to the Database
	 */

	public static void createConnecction() {

		try {
			conn = DriverManager.getConnection(ConfigsReader.getProperty("dbURL"),
					ConfigsReader.getProperty("dbUserName"), ConfigsReader.getProperty("dbPassword"));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Retrieves the Data and Store it inside a List
	 * 
	 * @return ListMap<String, String>
	 */

	public static List<Map<String, String>> storeDataFromDatabase(String sqlQuery) {

		try {
			st = conn.createStatement();
			rset = st.executeQuery(sqlQuery);
			ResultSetMetaData rsetData = rset.getMetaData();
			listData = new ArrayList<Map<String, String>>();

			while (rset.next()) {
				Map<String, String> rowMap = new LinkedHashMap<String, String>();

				for (int i = 1; i < rsetData.getColumnCount(); i++) {
					rowMap.put(rsetData.getColumnName(i), rset.getObject(i).toString());
				}
				listData.add(rowMap);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listData;
	}

	/**
	 * Closes all open connections to the databse
	 */
	public static void closeResources() {

		try {
			if (rset != null) {
				rset.close();
			}
			if (st != null) {
				st.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}
}
