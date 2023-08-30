package com.amdocs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    public void registerUser(User user) {
        try (Connection connection = JDBCConnection.getConnection()) {
            String query = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, user.getUsername());
            
            statement.setString(2, user.getPassword() );
            
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean authenticateUser(String username, String password) {
        try (Connection connection = JDBCConnection.getConnection()) {
            String query = "SELECT password FROM users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String StoredPassword = resultSet.getString("password");
                return password.equals(StoredPassword);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return false;
    }
}
