package com.simplilearn.jdbcapp.operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.simplilearn.jdbcapp.connection.DBConnection;

public class DeleteProductsWithParms {

	public static void main(String[] args) throws SQLException {

		Connection connection = null;
		PreparedStatement pstatement = null;
		
		try {
			// 1. get connection
			connection = DBConnection.getConnection();
			
			// 2. create a statement
			String deleteQuery  = "delete from product_data where id=?;";
			pstatement = connection.prepareStatement(deleteQuery);
			
			// 3. set query parameter
			pstatement.setInt(1, 7);
			
			// 4. execute query
			int result = pstatement.executeUpdate();
			
			System.out.println("Delete completed & No of rows affected ;> "+result);
		} catch (Exception e) {
			System.out.println("Delete product operation failed !");
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
