package base;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.*;

public class Starter {
	
	Starter() {
		
	}
	
	 public static void petIdThrowException(int petId, DBConnection dbConnection) throws InvalidPetIdException, SQLException{
		 	String searchQuery = null;
			ResultSet resultSet = null;
			PreparedStatement preparedStatement = null;
			
					 
			searchQuery = "SELECT * FROM `pet_store_system_db`.`pet` WHERE `pet_id` = ? ;";
			preparedStatement = dbConnection.connection.prepareStatement(searchQuery);
	        preparedStatement.setInt(1, petId);
	        resultSet = preparedStatement.executeQuery();
	        
	        if(resultSet.next()) {
	        	throw new InvalidPetIdException("Pet id is already present in the table, it should be unique");
	        } 
	    }
	
	public void MainMenu() throws SQLException, ClassNotFoundException {
		
		System.out.println("Pet Management System");
		System.out.println("..................................");
		System.out.println("Press C to CREATE a record in the table");
		System.out.println("Press R to Read all the records of the table");
		System.out.println("Press U to UPDATE any record of the table ");
		System.out.println("Press D to DELETE any record from the table");
		System.out.println("Press S to Search any record of the table");
		System.out.println("Press F to Find all the pets that are available for sale");
		System.out.println("Press B to find all the pets available in between the price range");
		System.out.println("Press E to EXIT");

		System.out.println("..................................");

		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please enter your choice");
		char choice = scanner.next().charAt(0);
		
		DBConnection dbConnection = null;
		DAOPet daoPet = null;
        
		while(choice != 'E') {
				
			    if(choice == 'C') {
			    	dbConnection = new DBConnection();
			    	daoPet = new DAOPet();
			    	scanner = new Scanner(System.in);

					System.out.println("Enter pet Id :");
					int petId = scanner.nextInt();
					scanner.nextLine();
			        
					try {
						
			        petIdThrowException(petId, dbConnection);
			      
					System.out.println("Enter pet Name :");
					String petName = scanner.nextLine();
						
					System.out.println("Enter pet Color :");
					String petColor = scanner.nextLine();
						
					System.out.println("Enter pet Price :");
					double petPrice = scanner.nextDouble();
					
					System.out.println("Enter whether pet is for sale or not (true/false): ");
					boolean petStatus = scanner.nextBoolean();
					 
					Pet pet_obj = new Pet(petId, petName, petColor, petPrice, petStatus);
					daoPet.insertData(pet_obj, dbConnection); 
					
					} catch(InvalidPetIdException e) {
						e.printStackTrace();
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
					scanner = new Scanner(System.in);
					int petId = scanner.nextInt();
					scanner.nextLine();
					
					daoPet.searchData(dbConnection, petId);
				} else if(choice == 'F') {
					dbConnection = new DBConnection();
					daoPet = new DAOPet();
					daoPet.findSaleData(dbConnection);
					
				} else if (choice == 'B') {
					dbConnection = new DBConnection();
					daoPet = new DAOPet();
					daoPet.rangeData(dbConnection);
				}
			    
			    System.out.println("Please enter your choice if you want to continue....");
			    System.out.println("..................................");
				System.out.println("Press C to CREATE a record in the table");
				System.out.println("Press R to Read all the records of the table");
				System.out.println("Press U to UPDATE any record of the table ");
				System.out.println("Press D to DELETE any record from the table");
				System.out.println("Press S to Search any record of the table");
				System.out.println("Press F to Find all the pets that are available for sale");
				System.out.println("Press B to find all the pets available in between the price range");
				System.out.println("Press E to EXIT");
			    choice = scanner.next().charAt(0);
			    scanner.nextLine();
		  
			}
			
			scanner.close();
	   }     
}
