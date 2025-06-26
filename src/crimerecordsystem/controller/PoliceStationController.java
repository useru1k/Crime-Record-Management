package crimerecordsystem.controller;

import crimerecordsystem.model.PoliceStation;
import crimerecordsystem.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PoliceStationController {
    public void addPoliceStation(PoliceStation station) {
        String query = "INSERT INTO police_station (stationName) VALUES (?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, station.getStationName());
            stmt.executeUpdate();
            System.out.println("Police station added successfully!");
        } catch (SQLException e) {
            System.out.println("Error adding police station: " + e.getMessage());
        }
    }
}
