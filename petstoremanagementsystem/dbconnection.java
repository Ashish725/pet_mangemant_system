package petstoremanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbconnection {

	public static Connection getConnection() {

		Connection con;

		try
		{
			String URL="jdbc:mysql://127.0.0.1:3306/petstore";
			String username="root";
			String password="root";
			con=DriverManager.getConnection(URL,username,password);
			return con;
		}catch(Exception e)
		{
			System.out.println(e);
		}

		return null;
	}
}
