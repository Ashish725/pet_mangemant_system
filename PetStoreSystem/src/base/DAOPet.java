package base;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DAOPet {
	
	Scanner scanner = null;
	
	public void insertData(Pet pet, DBConnection dbConnection) throws SQLException {
		// Insert: Create a new record
		
		try {
		
			char for_sale = '0';
			if(pet.getPetStatus()) for_sale = '1';
		
			String insertQuery = "INSERT INTO `pet_store_system_db`.`pet` (`pet_id`, `pet_name`, `pet_color`, `pet_price`, `sale_status`) VALUES ("
        		+ "'" + pet.getPetId() + "', " + "'" + pet.getPetName() + "', "
        		+ "'" + pet.getPetColor() + "', " + "'" + pet.getPetPrice() + "', "
        		+ "'" + for_sale + "');";
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
	        
	     
	        while(resultSet.next()) { 
	        		System.out.println("Pet Id : " + resultSet.getString(1));
	        		System.out.println("Pet Name : " + resultSet.getString(2));
	       	 		System.out.println("Pet Color : " + resultSet.getString(3));
	       	 		System.out.println("Pet Price : " + resultSet.getString(4));
	       	 		System.out.print("Pet for sale : ");
	       	 		if(resultSet.getString(5).charAt(0) == '1') {
	       	 			System.out.println("YES");
	       	 		} else System.out.println("NO");

	       	 		System.out.println("...........");
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
           
            scanner = new Scanner(System.in);
            
            System.out.println("Enter the Pet Id : ");
    		int petId = scanner.nextInt();
    		scanner.nextLine();
    		
    		String searchQuery = "SELECT * FROM `pet_store_system_db`.`pet` WHERE `pet_id` = ? ;";
    		PreparedStatement preparedStatement2 = dbConnection.connection.prepareStatement(searchQuery);
	        preparedStatement2.setInt(1, petId);
	        ResultSet resultSet = preparedStatement2.executeQuery();
			if(!resultSet.next()) {
				throw new InvalidPetIdException("Pet Id doesn't exist, try with different pet Id");
			}
    		
    		System.out.println("Enter the new pet price : ");
    		double updatedPetPrice = scanner.nextDouble();
    		 
            preparedStatement.setDouble(1, updatedPetPrice);
            preparedStatement.setInt(2, petId);
            preparedStatement.executeUpdate();
            
        } catch(InvalidPetIdException e) {
			e.printStackTrace();
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
			scanner = new Scanner(System.in);
			int petId = scanner.nextInt();
			
			String searchQuery = "SELECT * FROM `pet_store_system_db`.`pet` WHERE `pet_id` = ? ;";
    		PreparedStatement preparedStatement2 = dbConnection.connection.prepareStatement(searchQuery);
	        preparedStatement2.setInt(1, petId);
	        ResultSet resultSet = preparedStatement2.executeQuery();
			
	        
			if(!resultSet.next()) {
				throw new InvalidPetIdException("Pet Id doesn't exist, try with different pet Id");
			}
			
	        String deleteQuery = "DELETE FROM `pet` WHERE `pet_id` = ?";
	        PreparedStatement preparedStatement = dbConnection.connection.prepareStatement(deleteQuery);
	        preparedStatement.setInt(1, petId);

	        preparedStatement.executeUpdate();
		  
		} catch(InvalidPetIdException e) {
			e.printStackTrace();
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
	       	 	System.out.print("Pet for sale : ");
	       	 	
	       	 	if(resultSet.getString(5).charAt(0) == '1') {
	       	 		System.out.println("YES");
	       	 	} else System.out.println("NO");
	       	 	

	       		System.out.println("...........");
	       	 	available = false;
	        }
	        
	        if(available == true) {
	        	throw new InvalidPetIdException("Pet Id doesn't exist");
	        }
	        
		} catch(InvalidPetIdException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.getStackTrace();
		} finally {
			dbConnection.statement.close();
		    dbConnection.connection.close();
		}
		return available;
	}
	
	public void findSaleData(DBConnection dbConnection) throws SQLException {
		try {
			
			ResultSet resultSet = null;
			String readQuery = "SELECT * FROM `pet_store_system_db`.`pet` WHERE `sale_status`= 1;";
	        resultSet = dbConnection.statement.executeQuery(readQuery);
	     
	        	while(resultSet.next()) { 
	        		System.out.println("Pet Id : " + resultSet.getString(1));
	        		System.out.println("Pet Name : " + resultSet.getString(2));
	       	 		System.out.println("Pet Color : " + resultSet.getString(3));
	       	 		System.out.println("Pet Price : " + resultSet.getString(4));
	       	 		System.out.print("Pet for sale : ");
	       	 		if(resultSet.getString(5).charAt(0) == '1') {
	       	 			System.out.println("YES");
	       	 		} else System.out.println("NO");

	       	 		System.out.println("...........");
	        	}
			} catch(Exception e) {
					e.getStackTrace();			
			} finally {
		     dbConnection.statement.close();
		     dbConnection.connection.close();
			}
	}
	
	public void rangeData(DBConnection dbConnection) throws SQLException {
		// Delete : Deleting a record from the table
		
		try {
			
			System.out.println("Enter the Lower Limit : ");
			scanner = new Scanner(System.in);
			double lower_limit = scanner.nextDouble();
			scanner.nextLine();
			
			System.out.println("Enter the Upper Limit : ");
			double upper_limit = scanner.nextDouble();
			
			
			String searchQuery = "SELECT * FROM `pet_store_system_db`.`pet` WHERE `pet_price` BETWEEN ? AND ?;";
    		PreparedStatement preparedStatement = dbConnection.connection.prepareStatement(searchQuery);
	        preparedStatement.setDouble(1, lower_limit);
	        preparedStatement.setDouble(2, upper_limit);

	        ResultSet resultSet = preparedStatement.executeQuery();
			
	        while(resultSet.next()) { 
	       	 	System.out.println("Pet Id : " + resultSet.getString(1));
	       	 	System.out.println("Pet Name : " + resultSet.getString(2));
	      	 	System.out.println("Pet Color : " + resultSet.getString(3));
	       	 	System.out.println("Pet Price : " + resultSet.getString(4));
	       	 	System.out.print("Pet for sale : ");
	       	 	
	       	 	if(resultSet.getString(5).charAt(0) == '1') {
	       	 		System.out.println("YES");
	       	 	} else System.out.println("NO");
	       	 	

	       		System.out.println("...........");
	        }
		  
		}  catch (Exception e) {
			e.getStackTrace();			
		} finally {
			 dbConnection.statement.close();
		     dbConnection.connection.close();
		}
	}
}

