package com.amdocs;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		
		System.out.println(JDBCConnection.getConnection());
		Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Pet Management System!");
        System.out.println("Choose an option:");
        System.out.println("1. Login");
        System.out.println("2. Register");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (choice == 1) {
            loginUser.loginUsr(scanner);
        } else if (choice == 2) {
            registerUser.registerUsr(scanner);
        } else {
            System.out.println("Invalid choice. Exiting.");
        }
		//sc.close();
	}
}

