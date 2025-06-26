package crimerecordsystem.controller;

import crimerecordsystem.model.User;
import crimerecordsystem.util.DatabaseConnection;
import org.mindrot.jbcrypt.BCrypt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserController {
    public User login(String userName, String password) {
        String query = "SELECT * FROM users WHERE userName = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, userName);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String storedHash = rs.getString("passwordHash");
                if (BCrypt.checkpw(password, storedHash)) {
                    return new User(
                        rs.getInt("userId"),
                        rs.getString("userName"),
                        storedHash,
                        rs.getString("userRole")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Error during login: " + e.getMessage());
        }
        return null;
    }

    public void register(Scanner scanner) {
        System.out.print("Enter username: ");
        String userName = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter role (admin/officer): ");
        String userRole = scanner.nextLine();

        if (!userRole.equals("admin") && !userRole.equals("officer")) {
            System.out.println("Invalid role! Use 'admin' or 'officer'.");
            return;
        }

        String passwordHash = BCrypt.hashpw(password, BCrypt.gensalt());
        String query = "INSERT INTO users (userName, passwordHash, userRole) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, userName);
            stmt.setString(2, passwordHash);
            stmt.setString(3, userRole);
            stmt.executeUpdate();
            System.out.println("User registered successfully!");
        } catch (SQLException e) {
            System.out.println("Error during registration: " + e.getMessage());
        }
    }
}
