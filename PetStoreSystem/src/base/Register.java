package base;

import java.util.Scanner;

public class Register {
	public Register() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Register yourself to Pet Management System");
		System.out.println("..........................................");
		System.out.println("Please enter your email id : ");
		String email = scanner.nextLine();
		System.out.println("Please enter your password : ");
		String password = scanner.nextLine();
		
		User user = new User(email, password);
		DBConnection dbConnection = new DBConnection();
		
		try {
			String insertQuery = "INSERT INTO `pet_store_system_db`.`user` (`email`, `password`) VALUES ("
	        		+ "'" + user.getEmail() + "', " + "'" + user.getPassword() + "');";
				dbConnection.statement.executeUpdate(insertQuery);
				System.out.println("User created successfully");
			Login login = new Login();
			login.main(null);

		} catch(Exception e) {
			e.getStackTrace();
		}
		
	}
}
