package com.simplilearn.jdbcapp.operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.simplilearn.jdbcapp.connection.DBConnection;

public class AddProductWithQueryParams {

	public static void main(String[] args) throws SQLException {
		
		Connection connection = null;
		PreparedStatement pstatement = null;
		
		try {
			// 1. get connection
			connection = DBConnection.getConnection();
			
			// 2. create a statement
			String insertQuery  = "INSERT into product_data(product_name,product_price,product_description,product_brand) " + 
					"values(?, ?, ?, ?)";
			pstatement = connection.prepareStatement(insertQuery);
			
			//3 . set parameters
			pstatement.setString(1, "Apple watch WQICN series");
			pstatement.setDouble(2, 1534.5);
			pstatement.setString(3, "It is a smart watch");
			pstatement.setString(4, "Apple");
			
			// 3. execute query			
			int result = pstatement.executeUpdate();
						
			System.out.println("Insert completed & No of rows affected ;> "+result);
			
		} catch (Exception e) {
			System.out.println("Add product operation failed !");
		} finally {
			
			if(pstatement!=null) {
				pstatement.close();
			}
			
			if(connection!=null) {
				connection.close();
			}
		}


	}

}
