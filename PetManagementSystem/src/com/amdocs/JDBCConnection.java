package com.amdocs;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnection {
//	public static Connection con;
	public static Connection getConnection() {
		Connection con;
		try
		{  
//			Class.forName("com.mysql.cj.jdbc.Driver");  
			con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/pet_store_system","root","Joga@776");  
 
			return con;
		}
		catch(Exception e)
		{ System.out.println(e);
		}  
		return null;
	}
}
