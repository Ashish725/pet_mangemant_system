package base;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DAOPet {
	
	public void insertData(Pet pet, DBConnection dbConnection) throws SQLException {
		// Insert: Create a new record
		
		try {
        String insertQuery = "INSERT INTO `pet_store_system_db`.`pet` (`pet_id`, `pet_name`, `pet_color`, `pet_price`) VALUES ("
        		+ "'" + pet.getPetId() + "', "
        		+ "'" + pet.getPetName() + "', "
        		+ "'" + pet.getPetColor() + "', "
        		+ "'" + pet.getPetPrice() + "');";
        dbConnection.statement.executeUpdate(insertQuery);
		} catch(Exception e) {
			e.getStackTrace();
		} finally {
			dbConnection.statement.close();
	        dbConnection.connection.close();
		}
	}
	
	public void printData(DBConnection dbConnection) throws SQLException {
		// Read: Select all the records in the pet table
		
		try {
			ResultSet resultSet = null;
			String readQuery = "SELECT * FROM `pet_store_system_db`.`pet`;";
	        resultSet = dbConnection.statement.executeQuery(readQuery);
	        if(resultSet != null) {
	        	while(resultSet.next()) { 
	       		 	System.out.println("Pet Id : " + resultSet.getString(1));
	       		 	System.out.println("Pet Name : " + resultSet.getString(2));
	       		 	System.out.println("Pet Color : " + resultSet.getString(3));
	       		 	System.out.println("Pet Price : " + resultSet.getString(4));

	       		 	System.out.println("...........");
	        	}
	        }
		} catch(Exception e) {
			e.getStackTrace();			
		} finally {
		     dbConnection.statement.close();
		     dbConnection.connection.close();
		}
	}
	
	public void updateData(DBConnection dbConnection) throws SQLException {
		// Update : Altering a record in a table
		
        try {
        	String updateQuery = "UPDATE `pet` SET `pet_price` = ? WHERE `pet_id` = ?";
            PreparedStatement preparedStatement = dbConnection.connection.prepareStatement(updateQuery);
           
            Scanner scanner = new Scanner(System.in);
            
            System.out.println("Enter the Pet Id : ");
    		int petId = scanner.nextInt();
    		scanner.nextLine();
    		
    		System.out.println("Enter the new pet price : ");
    		double updatedPetPrice = scanner.nextDouble();
    		 
            preparedStatement.setDouble(1, updatedPetPrice);
            preparedStatement.setInt(2, petId);
            preparedStatement.executeUpdate();
            
        } catch(Exception e) {
        	e.getStackTrace();       	
        } finally {
        	dbConnection.statement.close();
            dbConnection.connection.close();
        }
        
	}
	
	public void deleteData(DBConnection dbConnection) throws SQLException {
		// Delete : Deleting a record from the table
		
		try {
			System.out.println("Enter the Pet id : ");
			Scanner scanner = new Scanner(System.in);
			int petId = scanner.nextInt();
			
	        String deleteQuery = "DELETE FROM `pet` WHERE `pet_id` = ?";
	        PreparedStatement preparedStatement = dbConnection.connection.prepareStatement(deleteQuery);
	        preparedStatement.setInt(1, petId);

	        preparedStatement.executeUpdate();
		  
		} catch (Exception e) {
			e.getStackTrace();			
		} finally {
			 dbConnection.statement.close();
		     dbConnection.connection.close();
		}
	}
	
	public boolean searchData(DBConnection dbConnection, int petId) throws SQLException {
		// Search : To search a record in the table 
		
		boolean available = true;
		
		try {
			System.out.println("......................");
			String searchQuery = null;
			ResultSet resultSet = null;
			PreparedStatement preparedStatement = null;
			
					 
			searchQuery = "SELECT * FROM `pet_store_system_db`.`pet` WHERE `pet_id` = ? ;";
			preparedStatement = dbConnection.connection.prepareStatement(searchQuery);
	        preparedStatement.setInt(1, petId);

	        resultSet = preparedStatement.executeQuery();
	       
	        while(resultSet.next()) { 
	        	System.out.println("Pet Id : " + petId + " exists..");
	       	 	System.out.println("Pet Id : " + resultSet.getString(1));
	       	 	System.out.println("Pet Name : " + resultSet.getString(2));
	      	 	System.out.println("Pet Color : " + resultSet.getString(3));
	       	 	System.out.println("Pet Price : " + resultSet.getString(4));

	       		System.out.println("...........");
	       	 	available = false;
	        }
	        
		} catch(Exception e) {
			e.getStackTrace();
		} finally {
			dbConnection.statement.close();
		    dbConnection.connection.close();
		}
		
		return available;
	}
}
