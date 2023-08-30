package base;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Login {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		System.out.println("Welcome to Pet Management System");
		System.out.println("................................");
		
		System.out.println("Already have an account ?");
		Scanner scanner = new Scanner(System.in);
		DBConnection dbConnection = new DBConnection();
		
		System.out.println("Enter email id : ");
		String email = scanner.nextLine();
		
		String searchMail = "SELECT email FROM user WHERE email = ?";
		PreparedStatement preparedStatement = dbConnection.connection.prepareStatement(searchMail);
        preparedStatement.setString(1, email);
        ResultSet resultSet = preparedStatement.executeQuery();
        
        if(resultSet.next()) {
        	System.out.println("Enter  password: ");
    		String password = scanner.nextLine();
    		
    		String searchPwd = "SELECT password FROM user WHERE password = ? AND email = ?";
    		preparedStatement = dbConnection.connection.prepareStatement(searchPwd);
            preparedStatement.setString(1, password);
            preparedStatement.setString(2, email);
            resultSet = preparedStatement.executeQuery();
    		
            if(resultSet.next()) {
            	System.out.println("Logged in successfully");
        		System.out.println(".....................");
        		Starter mainMenu = new Starter();
        		mainMenu.MainMenu();
            } else {
            	System.out.println("Incorrect password, try logging again!!");
            }
    		
    		
        } else {
        	Register register = new Register();
        }
        
		
		
	}

}
