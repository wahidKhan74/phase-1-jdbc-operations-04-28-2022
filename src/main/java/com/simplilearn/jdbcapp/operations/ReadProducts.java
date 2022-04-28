package com.simplilearn.jdbcapp.operations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.simplilearn.jdbcapp.connection.DBConnection;

public class ReadProducts {

	public static void main(String[] args) throws SQLException {

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			// 1. get connection
			connection = DBConnection.getConnection();
			
			// 2. create a statement
			statement = connection.createStatement();
			
			// 3. execute query
			String query  = "select * from product_data";
			resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				System.out.println("--------------------------------");
				System.out.println(resultSet.getInt("id"));
				System.out.println(resultSet.getString("product_name"));
				System.out.println(resultSet.getString("product_price"));
				System.out.println(resultSet.getString("product_description"));
				System.out.println(resultSet.getString("product_brand"));
				System.out.println(resultSet.getDate("create_date"));
				System.out.println(resultSet.getDate("expired_date"));
			}
			
		} catch (Exception e) {
			System.out.println("Read product operation failed !");
		} finally {
			if(resultSet!=null) {
				resultSet.close();
			}
			if(statement!=null) {
				statement.close();
			}
			
			if(connection!=null) {
				connection.close();
			}
		}

	}

}
