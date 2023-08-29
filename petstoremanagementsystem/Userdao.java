package petstoremanagementsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Userdao {

	private Connection connection;
	public Userdao() {

		connection = dbconnection.getConnection();
	}

	public void Register(user userob) throws SQLException {

		String insertValue = " insert into persons (LastName,FirstName, Password_, email)" + " values (?, ?, ?, ?)";

		try (PreparedStatement preparedStmt = connection.prepareStatement(insertValue);) {
			preparedStmt.setString(1, userob.getLastname());
			preparedStmt.setString(2, userob.getFirstname());
			preparedStmt.setString(3, userob.getPassword());
			preparedStmt.setString(4, userob.getEmail());
			preparedStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void Login(String username, String password) throws SQLException {
		try {
			String query = "SELECT type FROM persons WHERE email='"+ username+"' AND Password_='"+password+"';";
			PreparedStatement p = connection.prepareStatement(query);
			ResultSet rs = p.executeQuery();
			if (rs.next()) {
				System.out.println("You have Logged In successfully!!");
			} else
				throw new PasswordIncorrectException();
		} catch (PasswordIncorrectException e) {
			System.out.println(e);
		}
	}

}
