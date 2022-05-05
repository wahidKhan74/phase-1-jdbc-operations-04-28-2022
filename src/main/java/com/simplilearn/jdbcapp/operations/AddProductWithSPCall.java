package com.simplilearn.jdbcapp.operations;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.simplilearn.jdbcapp.connection.DBConnection;

public class AddProductWithSPCall {

	public static void main(String[] args) throws SQLException {
		
		Connection connection = null;
		CallableStatement cstatement = null;
		
		try {
			// 1. get connection
			connection = DBConnection.getConnection();
			
			// 2. create a statement
			cstatement = connection.prepareCall("{ call add_products(?,?) }");
			
			// 3. execute query
			cstatement.setString(1, "Lenovo Ideapad 330 laptop");
			cstatement.setDouble(2, 2546.67);
			int result = cstatement.executeUpdate();
			
			System.out.println("Insert operation is completed & No of rows affected :> "+result);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Add product operation failed !");
		} finally {
			
			if(cstatement!=null) {
				cstatement.close();
			}
			
			if(connection!=null) {
				connection.close();
			}
		}


	}

}
