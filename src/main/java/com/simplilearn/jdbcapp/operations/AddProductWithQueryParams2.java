package com.simplilearn.jdbcapp.operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.simplilearn.jdbcapp.connection.DBConnection;

public class AddProductWithQueryParams2 {

	public static void main(String[] args) throws SQLException {
		
		Connection connection = null;
		PreparedStatement pstatement = null;
		
		System.out.println("Welcome to BigCom Product");
		Scanner input = new Scanner(System.in);
		System.out.println("Enter product name : ");
		String productName = input.nextLine();
		System.out.println("Enter product price : ");
		double productPrice = input.nextDouble();
		System.out.println("Enter product description : ");
		String productDesc = input.nextLine();
		System.out.println("Enter product brand : ");
		String productBrand= input.nextLine();
		
		
		try {
			// 1. get connection
			connection = DBConnection.getConnection();
			
			// 2. create a statement
			String insertQuery  = "INSERT into product_data(product_name,product_price,product_description,product_brand) " + 
					"values(?, ?, ?, ?)";
			pstatement = connection.prepareStatement(insertQuery);
			
			//3 . set parameters
			pstatement.setString(1, productName);
			pstatement.setDouble(2, productPrice);
			pstatement.setString(3, productDesc);
			pstatement.setString(4, productBrand);
			
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
			if(input!=null) {
				input.close();
			}
		}


	}

}
