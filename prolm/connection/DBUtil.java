package com.zensar.prolm.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	
	public static Connection getConnection(){
		Connection con=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//System.out.println("Driver Loaded");
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Driver Not Loaded....Please Try again");
		}
		try {
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","TIGER");
			//System.out.println("DB Connected");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB not Connected....Please Try again");
		}
		return con;
		
		
	}
	
}
