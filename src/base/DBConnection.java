package base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBConnection {	
	private static final String url = "jdbc:mysql://localhost:3306/pet_store_system_db";
	private static final String username = "root";
	private static final String password = "putti!08PK";
	
	Connection connection = null;
	Statement statement = null;
	
	DBConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = (Connection) DriverManager.getConnection(url, username, password);
		    statement =  connection.createStatement();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
	    
	} 
}
