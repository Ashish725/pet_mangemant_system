package allfiles;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnection {

	public static Connection getConnection() {
		Connection con;
		try
		{  
  
			con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/Pet","root","Shubham@777");    
			return con;
		}
		catch(Exception e)
		{ System.out.println(e);
		}  
		return null;
	}
}

