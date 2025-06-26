package crimerecordsystem.controller;

import crimerecordsystem.model.Criminal;
import crimerecordsystem.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CriminalController {
    public void addCriminal(Scanner scanner) {
        System.out.print("Enter criminal name: ");
        String criminalName = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter gender (Male/Female/Other): ");
        String gender = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        System.out.print("Enter police station ID: ");
        int stationId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter identifying mark: ");
        String mark = scanner.nextLine();

        Criminal criminal = new Criminal(0, criminalName, age, gender, address, stationId, mark);
        String query = "INSERT INTO criminals (criminalName, age, gender, address, stationId, mark) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, criminal.getCriminalName());
            stmt.setInt(2, criminal.getAge());
            stmt.setString(3, criminal.getGender());
            stmt.setString(4, criminal.getAddress());
            stmt.setInt(5, criminal.getStationId());
            stmt.setString(6, criminal.getMark());
            stmt.executeUpdate();
            System.out.println("Criminal added successfully!");
        } catch (SQLException e) {
            System.out.println("Error adding criminal: " + e.getMessage());
        }
    }
}
