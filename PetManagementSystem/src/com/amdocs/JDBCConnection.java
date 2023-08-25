package com.amdocs;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnection {

	public static Connection getConnection() {
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pet_store_system_db","root","Gaurav@27");
			return con;
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}

}
