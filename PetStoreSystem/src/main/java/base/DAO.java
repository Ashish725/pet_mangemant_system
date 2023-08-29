package base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {
	public void insertPet(Pet pet) {
        try (Connection connection = JDBCConnection.getConnection()) {
            String query = "INSERT INTO pet ( pet_name, pet_price,pet_color,sale_status) VALUES (?, ?, ?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, pet.getPetId());
            statement.setString(2, pet.getPetName());
            statement.setDouble(3, pet.getPetPrice());
            statement.setString(4, pet.getPetColor());
            statement.setString(5, pet.getSaleStatus());
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
                pet.setPetPrice(resultSet.getInt("pet_price"));
                pet.setPetColor(resultSet.getString("pet_color"));
                pet.setSaleStatus(resultSet.getString("sale_status"));
                pets.add(pet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pets;
    }
	 public void updatePet(Pet pet) {
	        try (Connection connection = JDBCConnection.getConnection()) {
	            String query = "UPDATE pet SET pet_name = ?, pet_price = ?,pet_color = ?,sale_status = ? WHERE pet_id = ?";
	            PreparedStatement statement = connection.prepareStatement(query);
	           
	            statement.setString(1, pet.getPetName());
	            statement.setDouble(2, pet.getPetPrice());
	            statement.setString(3, pet.getPetColor());
	            statement.setString(4, pet.getSaleStatus());
	            statement.setInt(5, pet.getPetId());
	           
	            
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
//	 
	 public void deletePet(int petId) {
	        try (Connection connection = JDBCConnection.getConnection()) {
	        	
	            String query = "DELETE FROM pet WHERE pet_id = ?";
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
			 String query = "SELECT * FROM PET WHERE pet_id = ?";
			 PreparedStatement statement = connection.prepareStatement(query);
			 statement.setInt(1, petId);
			 ResultSet resultSet = statement.executeQuery();

	            while (resultSet.next()) {
	                Pet pet = new Pet();
	                pet.setPetId(resultSet.getInt("pet_id"));
	                pet.setPetName(resultSet.getString("pet_name"));
	                pet.setPetPrice(resultSet.getInt("pet_price"));
	                pet.setPetColor(resultSet.getString("pet_color"));
	                pet.setSaleStatus(resultSet.getString("sale_status"));
	                pets.add(pet);
	            }
			 
		 }
		 catch(SQLException e) {
			 e.printStackTrace();
		 }
		 return pets;
	 }
	 
	 public List<Pet> Search_by_saleStatus(String sale_status) {
		 List<Pet> pets = new ArrayList<>();
		 try(Connection connection = JDBCConnection.getConnection()){
			 String query = "SELECT * FROM PET WHERE sale_status = ?";
			 PreparedStatement statement = connection.prepareStatement(query);
			 statement.setString(1, sale_status);
			
			 
			 ResultSet resultSet = statement.executeQuery();

	            while (resultSet.next()) {
	                Pet pet = new Pet();
	                pet.setPetId(resultSet.getInt("pet_id"));
	                pet.setPetName(resultSet.getString("pet_name"));
	                pet.setPetPrice(resultSet.getInt("pet_price"));
	                pet.setPetColor(resultSet.getString("pet_color"));
	                pet.setSaleStatus(resultSet.getString("sale_status"));
	                pets.add(pet);
	            }
			 
		 }
		 catch(SQLException e) {
			 e.printStackTrace();
		 }
		 return pets;
	 }
	 
	 public List<Pet> Search_by_price_range(int lower_price, int upper_price ) {
		 List<Pet> pets = new ArrayList<>();
		 try(Connection connection = JDBCConnection.getConnection()){
			 String query = "SELECT * FROM PET WHERE pet_price BETWEEN  ? AND ?";
			 PreparedStatement statement = connection.prepareStatement(query);
			 statement.setInt(1, lower_price);
			 statement.setInt(2,upper_price);
			
			 
			 ResultSet resultSet = statement.executeQuery();

	            while (resultSet.next()) {
	                Pet pet = new Pet();
	                pet.setPetId(resultSet.getInt("pet_id"));
	                pet.setPetName(resultSet.getString("pet_name"));
	                pet.setPetPrice(resultSet.getInt("pet_price"));
	                pet.setPetColor(resultSet.getString("pet_color"));
	                pet.setSaleStatus(resultSet.getString("sale_status"));
	                pets.add(pet);
	            }
			 
		 }
		 catch(SQLException e) {
			 e.printStackTrace();
		 }
		 return pets;
	 }


}