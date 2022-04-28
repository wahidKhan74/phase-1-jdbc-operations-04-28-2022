package com.simplilearn.jdbcapp.operations;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.simplilearn.jdbcapp.connection.DBConnection;

public class UpdateProduct {

public static void main(String[] args) throws SQLException {
		
		Connection connection = null;
		Statement statement = null;
		
		try {
			// 1. get connection
			connection = DBConnection.getConnection();
			
			// 2. create a statement
			statement = connection.createStatement();
			
			// 3. execute query
			String insertQuery  = "UPDATE product_data set product_name='Lenovo Ideapad ZPMSA Model Laptop', "
					+ "product_price=54657.676 " + 
					" where id=3";
			int result = statement.executeUpdate(insertQuery);
			
			System.out.println("Update completed & No of rows affected ;> "+result);
			
		} catch (Exception e) {
			System.out.println("Updated product operation failed !");
		} finally {
			
			if(statement!=null) {
				statement.close();
			}
			
			if(connection!=null) {
				connection.close();
			}
		}


	}

}
