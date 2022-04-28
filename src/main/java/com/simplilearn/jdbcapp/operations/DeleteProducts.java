package com.simplilearn.jdbcapp.operations;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.simplilearn.jdbcapp.connection.DBConnection;

public class DeleteProducts {

	public static void main(String[] args) throws SQLException {

		Connection connection = null;
		Statement statement = null;
		
		try {
			// 1. get connection
			connection = DBConnection.getConnection();
			
			// 2. create a statement
			statement = connection.createStatement();
			
			// 3. execute query
			String deleteQuery  = "delete from product_data where id=3";
			int result = statement.executeUpdate(deleteQuery);
			
			System.out.println("Delete completed & No of rows affected ;> "+result);
		} catch (Exception e) {
			System.out.println("Delete product operation failed !");
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
