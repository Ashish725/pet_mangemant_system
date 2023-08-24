package base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.*;

public class Starter {
	
	Starter() {
		
	}
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		System.out.println("Pet Management System");
		System.out.println("..................................");
		System.out.println("Press C to CREATE a record in the table");
		System.out.println("Press R to Read all the records of the table");
		System.out.println("Press U to UPDATE any record of the table ");
		System.out.println("Press D to DELETE any record from the table");
		System.out.println("Press S to Search any record of the table");
		System.out.println("Press E to EXIT");

		System.out.println("..................................");

		Scanner scanner_obj = new Scanner(System.in);
		
		System.out.println("Please enter your choice");
		char choice = scanner_obj.next().charAt(0);
		
		DBConnection dbConnection = null;
		DAOPet daoPet = null;
        
		while(choice != 'E') {
				
			    if(choice == 'C') {
			    	dbConnection = new DBConnection();
			    	daoPet = new DAOPet();
			    	Scanner scanner = new Scanner(System.in);

					System.out.println("Enter pet Id :");
					int petId = scanner.nextInt();
					scanner.nextLine();
					
					boolean available = daoPet.searchData(dbConnection, petId);
					
					if(available == false) {
						System.out.println("PetId already exists, Try again with a different pet id");
					} else {
						dbConnection = new DBConnection();
						System.out.println("Enter pet Name :");
						String petName = scanner.nextLine();
						
						System.out.println("Enter pet Color :");
						String petColor = scanner.nextLine();
						
						System.out.println("Enter pet Price :");
						double petPrice = scanner.nextDouble();
					 
						Pet pet_obj = new Pet(petId, petName, petColor, petPrice);
						daoPet.insertData(pet_obj, dbConnection); 
					}
			    } else if(choice == 'R') {
					dbConnection = new DBConnection();
			    	daoPet = new DAOPet();
					daoPet.printData(dbConnection);
					
				} else if(choice == 'U') {
					dbConnection = new DBConnection();
			    	daoPet = new DAOPet();
					daoPet.updateData(dbConnection);
					
				} else if(choice == 'D') {
					dbConnection = new DBConnection();
			    	daoPet = new DAOPet();
					daoPet.deleteData(dbConnection);
					
				} else if(choice == 'S') {
					dbConnection = new DBConnection();
			    	daoPet = new DAOPet();
			    	
			    	System.out.println("Please enter PetId : ");
					Scanner scanner = new Scanner(System.in);
					int petId = scanner.nextInt();
					scanner.nextLine();
					
					daoPet.searchData(dbConnection, petId);
				}
			    
			    System.out.println("Please enter your choice if you want to continue....");
			    System.out.println("..................................");
				System.out.println("Press C to CREATE a record in the table");
				System.out.println("Press R to Read all the records of the table");
				System.out.println("Press U to UPDATE any record of the table ");
				System.out.println("Press D to DELETE any record from the table");
				System.out.println("Press S to Search any record of the table");
				System.out.println("Press E to EXIT");
			    choice = scanner_obj.next().charAt(0);
			    scanner_obj.nextLine();
		  
			}
	   }     
}
