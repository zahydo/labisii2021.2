/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.parkinglot.access;

import co.unicauca.parkinglot.domain.TypeEnum;
import co.unicauca.parkinglot.domain.Vehicle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Daniel Cerón
 */
public class VehicleRepository implements IVehicleRepository {

    private Connection conn = null;

    /**
     * Constructor
     */
    public VehicleRepository() {
        initializeDatabase();
    }

    /**
     * Save in database
     */
    @Override
    public boolean save(Vehicle newVehicle) {
        if (newVehicle == null) {
            return false;
        }
        try {
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Vehicle VALUES (?, ?)");
            pstmt.setString(1, newVehicle.getPlate());
            pstmt.setString(2, newVehicle.getType().toString());
            pstmt.execute();
            return true;
        } catch (SQLException e) {
            System.out.print(e.getMessage());
            return false;
        }
    }

    /**
     * Add vehicles from database to a list
     */
    @Override
    public List<Vehicle> list() {
        List<Vehicle> vehicles = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rQuery = stmt.executeQuery("SELECT * FROM Vehicle");
            while (rQuery.next()) {
                Vehicle newVehicle = new Vehicle();
                newVehicle.setPlate(rQuery.getString("Plate"));
                newVehicle.setType(TypeEnum.valueOf(rQuery.getString("Type")));
                vehicles.add(newVehicle);
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return vehicles;
    }

    private void initializeDatabase() {
        this.connect();
        String createTable = "CREATE TABLE Vehicle (Plate TEXT PRIMARY KEY NOT NULL, Type TEXT NOT NULL);";
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(createTable);
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }

    public void connect() {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite::memory:");
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }

    public void disconnect() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }

}