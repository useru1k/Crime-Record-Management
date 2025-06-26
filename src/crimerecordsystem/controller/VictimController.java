package crimerecordsystem.controller;

import crimerecordsystem.model.Victim;
import crimerecordsystem.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class VictimController {
    public void addVictim(Scanner scanner) {
        System.out.print("Enter victim name: ");
        String victimName = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter gender (Male/Female/Other): ");
        String gender = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();

        Victim victim = new Victim(0, victimName, age, gender, address);
        String query = "INSERT INTO victims (victimName, age, gender, address) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, victim.getVictimName());
            stmt.setInt(2, victim.getAge());
            stmt.setString(3, victim.getGender());
            stmt.setString(4, victim.getAddress());
            stmt.executeUpdate();
            System.out.println("Victim added successfully!");
        } catch (SQLException e) {
            System.out.println("Error adding victim: " + e.getMessage());
        }
    }
}
