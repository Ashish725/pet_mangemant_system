package allfiles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class petData {
	public void insertPet(Pet pet) {
        try (Connection connection = JDBCConnection.getConnection()) {
            String query = "INSERT INTO pettable (pet_id, pet_name, pet_retail_price,pet_color) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, pet.getPetId());
            statement.setString(2, pet.getPetName());
            statement.setDouble(3, pet.getPetPrice());
            statement.setString(4, pet.getPetColor());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	public List<Pet> getAllPets() {
        List<Pet> pets = new ArrayList<>();

        try (Connection connection = JDBCConnection.getConnection()) {
            String query = "SELECT * FROM pettable";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Pet pet = new Pet();
                pet.setPetId(resultSet.getInt("pet_id"));
                pet.setPetName(resultSet.getString("pet_name"));
                pet.setPetPrice(resultSet.getInt("pet_retail_price"));
                pet.setPetColor(resultSet.getString("pet_color"));
                pets.add(pet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pets;
    }
	 public void updatePet(Pet pet) {
	        try (Connection connection = JDBCConnection.getConnection()) {
	            String query = "UPDATE pettable SET pet_name = ?, pet_retail_price = ?,pet_color = ? WHERE pet_id = ?";
	            PreparedStatement statement = connection.prepareStatement(query);
	           
	            statement.setString(1, pet.getPetName());
	            statement.setDouble(2, pet.getPetPrice());
	            statement.setString(3, pet.getPetColor());
	            statement.setInt(4, pet.getPetId());
	            
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 
	 public void deletePet(int petId) {
	        try (Connection connection = JDBCConnection.getConnection()) {
	        	
	            String query = "DELETE FROM pettable WHERE pet_id = ?";
	            PreparedStatement statement = connection.prepareStatement(query);
	            statement.setInt(1, petId);
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 
	 public List<Pet> search(int petId) {
		 List<Pet> pets = new ArrayList<>();
		 try(Connection connection = JDBCConnection.getConnection()){
			 String query = "SELECT * FROM pettable WHERE pet_id = ?";
			 PreparedStatement statement = connection.prepareStatement(query);
			 statement.setInt(1, petId);
			 ResultSet resultSet = statement.executeQuery();

	            while (resultSet.next()) {
	                Pet pet = new Pet();
	                pet.setPetId(resultSet.getInt("pet_id"));
	                pet.setPetName(resultSet.getString("pet_name"));
	                pet.setPetPrice(resultSet.getInt("pet_retail_price"));
	                pet.setPetColor(resultSet.getString("pet_color"));
	                pets.add(pet);
	            }
			 
		 }
		 catch(SQLException e) {
			 e.printStackTrace();
		 }
		 return pets;
	 }
     public void searchPrice() {
    	 Scanner sc=new Scanner(System.in);
    	 System.out.println("Enter first price:- "+" ");
    	 int price1=sc.nextInt();
    	 System.out.println("Enter second price:- "+" ");
    	 int price2=sc.nextInt();
    	 
    	 
    	 try (Connection connection = JDBCConnection.getConnection()) {
             String query = "SELECT * FROM pettable Where pet_retail_price BETWEEN " +price1 + " AND " +price2+ ";";
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery();

             while (resultSet.next()) {
             	System.out.println("Pet ID: " + resultSet.getInt("Pet_id"));
 			    System.out.println("Pet Name: " + resultSet.getString("Pet_name"));
 			    System.out.println("Pet Price: " + resultSet.getInt("Pet_retail_price"));
 			    System.out.println("Pet Color: " + resultSet.getString("Pet_color"));
 			   
 			    System.out.println("--------------------------");
 			}
             }
    	 
    	 catch (SQLException e) {
             e.printStackTrace();
         }
     }
     
}