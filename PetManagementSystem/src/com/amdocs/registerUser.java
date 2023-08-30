package com.amdocs;

import java.io.IOException;
import java.util.Scanner;

public class registerUser {
	 static void registerUsr(Scanner scanner) throws IOException {
	        System.out.print("Enter a username: ");
	        String username = scanner.nextLine();

	        System.out.print("Enter a password: ");
	        String password = scanner.nextLine();

	        User newUser = new User();
	        newUser.setUsername(username);
	        newUser.setPassword(password);

	        UserDAO userDAO = new UserDAO();
	        userDAO.registerUser(newUser);

	        System.out.println("Registration successful!");
	        System.out.println("Register Kar Liya nahh Abb Login Kar !!!");
	        loginUser.loginUsr(scanner);
	    }
}
