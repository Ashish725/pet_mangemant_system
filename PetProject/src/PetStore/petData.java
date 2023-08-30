package PetStore;


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
            String query = "INSERT INTO pet (pet_id, pet_name, pet_retail_price,pet_color) VALUES (?, ?, ?, ?)";
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
            String query = "SELECT * FROM pet";
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
	            String query = "UPDATE pet SET pet_name = ?, pet_retail_price = ?,pet_color = ? WHERE pet_id = ?";
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
	        	
	        	Scanner sc =new Scanner(System.in);
	        	String sql ="SELECT * FROM PET WHERE pet_id = " +petId + ";";
	        	PreparedStatement ps = connection.prepareStatement(sql);
	        	ResultSet rs = ps.executeQuery();
        	
	        	if(rs.next()) {
					System.out.println("\nPet ID is:- " +rs.getInt("pet_id"));
					System.out.println("Pet Name is:- " +rs.getString("pet_name"));
					System.out.println("Pet Color is:- " +rs.getString("pet_color"));
					System.out.println("Pet Price is:- " +rs.getInt("pet_retail_price"));
					
				}
	        	
	        	System.out.println("Are you Sure you want to delete this? \n1.Yes\t\t2.No");
				System.out.println("Enter your choice in numerical :- ");
				int opt = sc.nextInt();
				
	        	if(opt==1) {
	        		String query = "DELETE FROM pet WHERE pet_id = ?" ;
	 	            ps = connection.prepareStatement(query);
	 	            ps.setInt(1, petId);
	 	           
	 	            
	 	           int rowsAffected = ps.executeUpdate();
					
					if (rowsAffected > 0) {
						System.out.println(rowsAffected + " row(s) deleted successfully. ");

					} 
					else {
						System.out.println("No matching property found.");

					}
	        	}
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 
	 public List<Pet> search(int petId) {
		 List<Pet> pets = new ArrayList<>();
		 try(Connection connection = JDBCConnection.getConnection()){
			 String query = "SELECT * FROM PET WHERE pet_id = ?";
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
		 Scanner sc1 =new Scanner(System.in);
		 System.out.println("Enter first price:- "+" ");
		 int price1=sc1.nextInt();
		 System.out.println("Enter second price:-"+" ");
		 int price2=sc1.nextInt();
		 
		 
		 try(Connection connection = JDBCConnection.getConnection()){
			 String query1 = "SELECT * FROM PET WHERE pet_retail_price BETWEEN " +price1 + " AND " +price2+ " ;" ;
			 PreparedStatement statement = connection.prepareStatement(query1);
			// statement.setInt(1, petId);
			 ResultSet resultSet = statement.executeQuery();

	            while (resultSet.next()) {
	               // Pet pet = new Pet();
	            	
	                System.out.println("Pet ID : " +resultSet.getInt("pet_id"));
	                System.out.println("Pet Name : " +resultSet.getString("pet_name"));
	                System.out.println("Pet Price : " +resultSet.getInt("pet_retail_price"));
	                System.out.println("Pet Color : " +resultSet.getString("pet_color"));
	                //pets.add(pet);
	                System.out.println("----------------------------");
	            }
			 
		 }
		 catch(SQLException e) {
			 e.printStackTrace();
		 }
	 }


}
