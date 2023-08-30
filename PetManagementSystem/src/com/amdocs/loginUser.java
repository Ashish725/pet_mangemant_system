package com.amdocs;

import java.io.IOException;
import java.util.Scanner;

public class loginUser {
	 static void loginUsr(Scanner scanner) throws IOException {
	        System.out.print("Enter your username: ");
	        String username = scanner.nextLine();

	        System.out.print("Enter your password: ");
	        String password = scanner.nextLine();

	        UserDAO userDAO = new UserDAO();
	        boolean isAuthenticated = userDAO.authenticateUser(username, password);

	        if (isAuthenticated) {
	            System.out.println("Login successful!");
	            Operations.crudOp();
	            
	        } else {
	            System.out.println("Login failed. Incorrect username or password.");
	        }
	    }
}
