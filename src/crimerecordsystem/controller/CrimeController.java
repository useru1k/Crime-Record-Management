package crimerecordsystem.controller;

import crimerecordsystem.model.Crime;
import crimerecordsystem.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.Scanner;

public class CrimeController {
    public void addCrime(Scanner scanner) {
        System.out.print("Enter crime date (YYYY-MM-DD): ");
        String crimeDate = scanner.nextLine();
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        System.out.print("Enter details: ");
        String details = scanner.nextLine();
        System.out.print("Enter police station ID: ");
        int stationId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter status (Open/Closed/Under Investigation): ");
        String status = scanner.nextLine();

        Crime crime = new Crime(0, Date.valueOf(crimeDate), description, details, stationId, status);
        String query = "INSERT INTO crimes (crimeDate, description, details, stationId, status) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setDate(1, crime.getCrimeDate());
            stmt.setString(2, crime.getDescription());
            stmt.setString(3, crime.getDetails());
            stmt.setInt(4, crime.getStationId());
            stmt.setString(5, crime.getStatus());
            stmt.executeUpdate();
            System.out.println("Crime added successfully!");
        } catch (SQLException e) {
            System.out.println("Error adding crime: " + e.getMessage());
        }
    }

    public void updateCrime(Scanner scanner) {
        System.out.print("Enter crime ID to update: ");
        int crimeId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new crime date (YYYY-MM-DD): ");
        String crimeDate = scanner.nextLine();
        System.out.print("Enter new description: ");
        String description = scanner.nextLine();
        System.out.print("Enter new details: ");
        String details = scanner.nextLine();
        System.out.print("Enter new police station ID: ");
        int stationId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new status (Open/Closed/Under Investigation): ");
        String status = scanner.nextLine();

        String query = "UPDATE crimes SET crimeDate = ?, description = ?, details = ?, stationId = ?, status = ? WHERE crimeId = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setDate(1, Date.valueOf(crimeDate));
            stmt.setString(2, description);
            stmt.setString(3, details);
            stmt.setInt(4, stationId);
            stmt.setString(5, status);
            stmt.setInt(6, crimeId);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Crime updated successfully!");
            } else {
                System.out.println("Crime ID not found!");
            }
        } catch (SQLException e) {
            System.out.println("Error updating crime: " + e.getMessage());
        }
    }

    public void deleteCrime(Scanner scanner) {
        System.out.print("Enter crime ID to delete: ");
        int crimeId = scanner.nextInt();
        scanner.nextLine();

        String query = "DELETE FROM crimes WHERE crimeId = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, crimeId);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Crime deleted successfully!");
            } else {
                System.out.println("Crime ID not found!");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting crime: " + e.getMessage());
        }
    }

    public void linkCriminalToCrime(Scanner scanner) {
        System.out.print("Enter criminal ID: ");
        int criminalId = scanner.nextInt();
        System.out.print("Enter crime ID: ");
        int crimeId = scanner.nextInt();
        scanner.nextLine();

        String query = "INSERT INTO criminals_of_crime (criminalId, crimeId) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, criminalId);
            stmt.setInt(2, crimeId);
            stmt.executeUpdate();
            System.out.println("Criminal linked to crime successfully!");
        } catch (SQLException e) {
            System.out.println("Error linking criminal to crime: " + e.getMessage());
        }
    }

    public void linkVictimToCrime(Scanner scanner) {
        System.out.print("Enter victim ID: ");
        int victimId = scanner.nextInt();
        System.out.print("Enter crime ID: ");
        int crimeId = scanner.nextInt();
        scanner.nextLine();

        String query = "INSERT INTO victims_of_crime (victimId, crimeId) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, victimId);
            stmt.setInt(2, crimeId);
            stmt.executeUpdate();
            System.out.println("Victim linked to crime successfully!");
        } catch (SQLException e) {
            System.out.println("Error linking victim to crime: " + e.getMessage());
        }
    }

    public void viewAllCrimes() {
        String query = "SELECT c.crimeId, c.crimeDate, c.description, c.details, c.stationId, c.status, " +
                       "GROUP_CONCAT(crim.criminalName) as criminals, GROUP_CONCAT(v.victimName) as victims " +
                       "FROM crimes c " +
                       "LEFT JOIN criminals_of_crime coc ON c.crimeId = coc.crimeId " +
                       "LEFT JOIN criminals crim ON coc.criminalId = crim.criminalId " +
                       "LEFT JOIN victims_of_crime voc ON c.crimeId = voc.crimeId " +
                       "LEFT JOIN victims v ON voc.victimId = v.victimId " +
                       "GROUP BY c.crimeId";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("Crime ID: " + rs.getInt("crimeId"));
                System.out.println("Date: " + rs.getDate("crimeDate"));
                System.out.println("Description: " + rs.getString("description"));
                System.out.println("Details: " + rs.getString("details"));
                System.out.println("Police Station ID: " + rs.getInt("stationId"));
                System.out.println("Status: " + rs.getString("status"));
                System.out.println("Criminals: " + (rs.getString("criminals") != null ? rs.getString("criminals") : "None"));
                System.out.println("Victims: " + (rs.getString("victims") != null ? rs.getString("victims") : "None"));
                System.out.println("------------------------");
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving crimes: " + e.getMessage());
        }
    }
}
