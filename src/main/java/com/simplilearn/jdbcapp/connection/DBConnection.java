package com.simplilearn.jdbcapp.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	// datasource config
	static final String DBURL = "jdbc:mysql://localhost:3306/ecom_system_db";
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String USERNAME = "root";
	static final String PASSWORD = "root";
	
	public static Connection getConnection() {
		Connection  connection = null;
		try {
			// 1. register a jdbc driver
			Class.forName(JDBC_DRIVER);
			// 2. get connection
			connection = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
			
			if(connection != null)	 
				System.out.println("The DB Connection is successfull !");
			else 
				System.out.println("Failed to create a db connection !");
		} catch (ClassNotFoundException  e) {
			System.out.println("Eception Occured : "+e.getClass());
			System.out.println("Eception Message : "+e.getMessage());
		} catch (SQLException e) {
			System.out.println("Eception Occured : "+e.getClass());
			System.out.println("Eception Message : "+e.getMessage());
		}
		return connection;
	}

}
