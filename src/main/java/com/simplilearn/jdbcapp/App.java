package com.simplilearn.jdbcapp;

import com.simplilearn.jdbcapp.connection.DBConnection;

public class App {
	
	public static void main(String[] args) {
		
		DBConnection.getConnection();
	}
}
