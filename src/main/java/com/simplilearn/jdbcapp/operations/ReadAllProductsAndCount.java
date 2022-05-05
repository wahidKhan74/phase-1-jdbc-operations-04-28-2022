package com.simplilearn.jdbcapp.operations;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.simplilearn.jdbcapp.connection.DBConnection;

public class ReadAllProductsAndCount {

	public static void main(String[] args) throws SQLException {

		Connection connection = null;
		CallableStatement cstatement = null;
		ResultSet resultSet1 = null;  // get all products
		ResultSet resultSet2 = null;  // get total product count
		
		try {
			// 1. get connection
			connection = DBConnection.getConnection();
			
			// 2. create a statement
			cstatement = connection.prepareCall("{call get_all_products_and_count() }");
			
			// 3. execute query :: // get all products
			resultSet1 = cstatement.executeQuery();
			
			while(resultSet1.next()) {
				System.out.println("--------------------------------");
				System.out.println(resultSet1.getInt("id"));
				System.out.println(resultSet1.getString("product_name"));
				System.out.println(resultSet1.getString("product_price"));
				System.out.println(resultSet1.getString("product_description"));
				System.out.println(resultSet1.getString("product_brand"));
				System.out.println(resultSet1.getDate("create_date"));
				System.out.println(resultSet1.getDate("expired_date"));
			}
			
			cstatement.getMoreResults();
			
			// get total product count
			resultSet2 = cstatement.getResultSet();
			
			
			while(resultSet2.next()) {
				System.out.println("--------------------------------------------------");
				System.out.println("The Total Products Count :: "+ resultSet2.getInt("total_product"));
				System.out.println("--------------------------------------------------");
			}
			
		} catch (Exception e) {
			System.out.println("Get stored procedure operation failed !");
		} finally {
			if(resultSet1!=null) {
				resultSet1.close();
			}
			if(resultSet2!=null) {
				resultSet2.close();
			}
			if(cstatement!=null) {
				cstatement.close();
			}			
			if(connection!=null) {
				connection.close();
			}
		}

	}

}
