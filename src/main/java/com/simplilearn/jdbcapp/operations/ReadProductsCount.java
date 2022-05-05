package com.simplilearn.jdbcapp.operations;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.simplilearn.jdbcapp.connection.DBConnection;

public class ReadProductsCount {

	public static void main(String[] args) throws SQLException {

		Connection connection = null;
		CallableStatement cstatement = null;
		ResultSet resultSet = null;
		
		try {
			// 1. get connection
			connection = DBConnection.getConnection();
			
			// 2. create a statement
			cstatement = connection.prepareCall("{call get_products_count() }");
			
			// 3. execute query
			resultSet = cstatement.executeQuery();
			
			while(resultSet.next()) {
				System.out.println("--------------------------------------------------");
				System.out.println("The Total Products Count :: "+ resultSet.getInt("total_product"));
				System.out.println("--------------------------------------------------");
			}
			
		} catch (Exception e) {
			System.out.println("Get stored procedure operation failed !");
		} finally {
			if(resultSet!=null) {
				resultSet.close();
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
