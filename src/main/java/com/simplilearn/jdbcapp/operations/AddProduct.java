package com.simplilearn.jdbcapp.operations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.simplilearn.jdbcapp.connection.DBConnection;

public class AddProduct {

	public static void main(String[] args) throws SQLException {
		
		Connection connection = null;
		Statement statement = null;
		
		try {
			// 1. get connection
			connection = DBConnection.getConnection();
			
			// 2. create a statement
			statement = connection.createStatement();
			
			// 3. execute query
			String insertQuery  = "INSERT into product_data(product_name,product_price,product_description,product_brand) " + 
					"values('Apple Iphone 12 MAX PRO', 1435.56, 'It is a smart phone', 'Apple')";
			int result = statement.executeUpdate(insertQuery);
			
			System.out.println("Insert completed & No of rows affected ;> "+result);
			
		} catch (Exception e) {
			System.out.println("Add product operation failed !");
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
