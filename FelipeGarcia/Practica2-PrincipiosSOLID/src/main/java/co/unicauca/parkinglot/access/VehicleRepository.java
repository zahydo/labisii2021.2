/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 *
 * @author Andres Garcia
 * @author Felipe Garcia
 */
public class VehicleRepository implements IVehicleRepository {

    private Connection conn = null;

    /**
     * Constructor
     *
     */
    public VehicleRepository() {
        initDatabase();
    }

    /**
     * Metodo para agregar vehiculos a la base de datos
     *
     * @param newVehicle
     * @return boolean
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
     * Metodo para agregar los vehiculos de la base de datos a la lista list
     *
     * @return list
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

    /**
     * Metodo que inicia la base de datos
     */
    private void initDatabase() {
        this.connect();
        String createTable = "CREATE TABLE Vehicle (Plate TEXT PRIMARY KEY NOT NULL, Type TEXT NOT NULL);";
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(createTable);
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }

    /**
     * Metodo que conecta la base de datos
     */
    public void connect() {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite::memory:");
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }

    /**
     * Metodo que desconecta la base de datos
     */
    public void disconnect() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }

}
