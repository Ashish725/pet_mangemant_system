package petstoremanagementsystem;

import java.sql.Connection;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
public class petDao{

	private Connection connection;

	public petDao() {

		connection = dbconnection.getConnection();
	}

	public void insert(pet petob) throws SQLException {

		String insertValue = " insert into pet (petid,petName, petType, petAge)" + " values (?, ?, ?, ?)";

		try (PreparedStatement preparedStmt = connection.prepareStatement(insertValue);) {
			preparedStmt.setInt(1, petob.getPetId());
			preparedStmt.setString(2, petob.getPetName());
			preparedStmt.setString(3, petob.getPetType());
			preparedStmt.setString(4, petob.getPetAge());
			preparedStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public void search(int id) throws SQLException {

		String query = "select * from pet where petid=" + id;
		PreparedStatement p = connection.prepareStatement(query);
		ResultSet rs = p.executeQuery();

		try {
			if (rs.next() == false)
				throw new invalidId();
			else {
				int petid = rs.getInt("petid");
				String name = rs.getString("petName");
				String type = rs.getString("petType");
				String age = rs.getString("petAge");

				System.out.println("Pet Id: "+petid + "  Pet Name: "+name+"  Pet Category: "+type+ "  Pet Age: " + age);
			}
		} catch (invalidId ex) {
			System.out.println(ex);
		}
	}


	public void delete(int id) throws SQLException {

		String query = "DELETE FROM pet WHERE petid = '" + id + "' ";
		PreparedStatement p = connection.prepareStatement(query);
		p.executeUpdate();
		System.out.println("The row deleted successfully");
	}


	public void display() throws SQLException {
		String query = "select * from pet";
		PreparedStatement p = connection.prepareStatement(query);
		ResultSet rs = p.executeQuery();

		try{if(rs.next()==false)
		{
			throw new NullPointerException();
		}
		do{
			int petid = rs.getInt("petid");
			String name = rs.getString("petName");
			String type = rs.getString("petType");
			String age = rs.getString("petAge");

			System.out.println("Pet Id: "+petid + "  Pet Name: "+name+"  Pet Category: "+type+ "  Pet Age: " + age);				

		}while(rs.next());
		}catch(NullPointerException e)
		{
			System.out.println(e);
		}
	}


	public void update(pet petob) throws SQLException {

		String query = "update pet set petName=?,petType=?,petAge=? where petid=? ";
		PreparedStatement p = connection.prepareStatement(query);
		p.setString(1, petob.getPetName());
		p.setString(2, petob.getPetType());
		p.setString(3, petob.getPetAge());
		p.setInt(4, petob.getPetId());
		p.executeUpdate();
		System.out.println("The row updated successfully");
	}


	public void countPet() throws SQLException {

		String query = "SELECT distinct petType, COUNT(*) AS Count FROM   pet GROUP  BY petType;";
		PreparedStatement p = connection.prepareStatement(query);
		ResultSet rs = p.executeQuery();
		try{
			if(rs.next()==false)
				throw new NullPointerException();
			else
			{
				do {
					String type = rs.getString("petType");
					int count = rs.getInt("Count");
					System.out.println("Pet Category: "+type+ "  Pet Count: "+count);				
				}while(rs.next());
			}
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}


	public void countVaccinatedPet() throws SQLException {

		String query = "SELECT distinct vaccinated, COUNT(*) AS Count FROM   pet GROUP  BY vaccinated;";
		PreparedStatement p = connection.prepareStatement(query);
		ResultSet rs = p.executeQuery();
		try {
			if(rs.next()==false)
				throw new NullPointerException();
			else
			{
				do {
					String type = rs.getString("vaccinated");
					int count = rs.getInt("Count");
					System.out.println("Vaccination Status: "+type+ "  Pet Count: "+count);				
				}while(rs.next());
			}
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}

	public void vaccinatedPetType(String pet) throws SQLException{

		String query = "SELECT distinct vaccinated, COUNT(*) AS Count FROM   pet where petType='" + pet + "' group by vaccinated;";
		PreparedStatement p = connection.prepareStatement(query);
		ResultSet rs = p.executeQuery();
		while(rs.next())
		{
			String petvac=rs.getString("vaccinated");
			int count = rs.getInt("Count");
			System.out.println("Pet category: "+pet+" Vaccination Status: "+petvac+" Pet Count: "+count);
		}
	}

	public int checkCategory(String pet) throws SQLException
	{
		String query="Select distinct petType from pet;";
		PreparedStatement p =connection.prepareStatement(query);
		ResultSet rs=p.executeQuery();
		HashSet<String> hs=new HashSet<String>();
		while(rs.next())
		{
			String category = rs.getString("petType");
			hs.add(category);
		}
		if(hs.contains(pet)==false)
			return 0;
		return 1;
	}
}


