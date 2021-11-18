/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicauca.parkinglot.access;

import co.unicauca.parkinglot.domain.TypeEnum;
import co.unicauca.parkinglot.domain.Vehicle;
import co.unicauca.parkinglot.domain.service.Service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 57322
 */
public class VehicleRepository implements IVehicleRepository {

    //Atributos
    private Connection conn;
    private ArrayList<Vehicle> LstVehicle;

    //Constrctor
    public VehicleRepository() {
        initDatabase();
    }

    public void connect() {
        // Si se quiere guardar los datos a un archivo
        String url = "jdbc:sqlite:./mydatabase.db";

        // Guarda los datos en memoria RAM
        //String url = "jdbc:sqlite::memory:";
        try {
            conn = DriverManager.getConnection(url);

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void disconnect() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    private void initDatabase() {
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS Vehicles (\n"
                + "	Plate text NOT NULL,\n"
                + "	Type text NOT NULL\n"
                + ");";

        try {
            this.connect();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



    @Override
    public boolean save(Vehicle v) {
        
        try {
            //Validate product
            if (v == null || v.getPlate().equals("") || v.getPlate().isEmpty()) {
                return false;
            }
            this.connect();
            String sql = "INSERT INTO Vehicles (  Plate, Type ) "
                    + "VALUES ( ?, ? )";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, v.getPlate());
            pstmt.setString(2, v.getType().toString());
            pstmt.executeUpdate();
            pstmt.close();
            this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ArrayList<Vehicle> list() {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        try {

            String sql = "SELECT Plate, Type FROM Vehicles";
            this.connect();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Vehicle newVehicle = new Vehicle();
                newVehicle.setPlate(rs.getString("Plate"));
                newVehicle.setType(getType(rs.getString("Type")));//Obtiene el valor del ENUM
                vehicles.add(newVehicle);
            }
            this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vehicles;
    }

    public TypeEnum getType(String type) {

        TypeEnum vehicleType = null;

        switch (type) {

            case "CAR":
                vehicleType = TypeEnum.CAR;
                break;
            case "MOTO":
                vehicleType = TypeEnum.MOTO;
                break;
            case "TRUCK":
                vehicleType = TypeEnum.TRUCK;
                break;
            default:
                break;

        }

        return vehicleType;
    }

}
