package com.simplilearn.jdbcapp.operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.simplilearn.jdbcapp.connection.DBConnection;

public class UpdateProductWithParams {

public static void main(String[] args) throws SQLException {
		
		Connection connection = null;
		PreparedStatement pstatement = null;
		
		try {
			// 1. get connection
			connection = DBConnection.getConnection();
			
			// 2. create a statement
			String updateQuery  = "UPDATE product_data set product_name=?, "
					+ "product_price=?, product_description=?, product_brand=? where id=?";
			pstatement = connection.prepareStatement(updateQuery);
			
			// 3. set query parameters
			pstatement.setString(1,"Acer Gaming Inovation serise laptop");
			pstatement.setDouble(2,5654.677);
			pstatement.setString(3,"It is a gaming laptop");
			pstatement.setString(4,"Acer");
			pstatement.setInt(5,7);
			
			// 3. execute query			
			int result = pstatement.executeUpdate();
			
			System.out.println("Update completed & No of rows affected ;> "+result);
			
		} catch (Exception e) {
			System.out.println("Updated product operation failed !");
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
