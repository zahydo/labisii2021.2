/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.access;

import co.unicauca.parkinglot.domain.Vehicle;
import co.unicauca.parkinglot.domain.service.Service;
import co.unicauca.parkinglot.infra.Utilities;
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

public class VehicleRepository implements IVehicleRepository {

    //bd
    private Connection conn;

    /**
     * constructor sin parametros
     */
    public VehicleRepository() {
        initDatabase();
    }

    /**
     * Inicializacion de la base de datos
     */
    private void initDatabase() {
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS Vehicle (\n"
                + "	VehiclePlate text PRIMARY KEY,\n"
                + "	Type text NOT NULL \n"
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

    /**
     * Conexion a la base de datos
     */
    public void connect() {
        // Si se quiere guardar los datos a un archivo
        //String url = "jdbc:sqlite:./mydatabase.db";    
        // Guarda los datos en memoria RAM
        String url = "jdbc:sqlite::memory:";
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Desconexion de la base de datos
     */
    public void disconnect() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Guarda un vehiculo en la tabla Vehicle
     *
     * @param newVehicle
     * @return boolean
     */
    @Override
    public boolean save(Vehicle newVehicle) {
        try {
            //Validate product
            if (newVehicle == null) {
                return false;
            }
            //this.connect();
            String sql = "INSERT INTO Vehicle ( VehiclePlate, Type ) "
                    + "VALUES ( ?, ? )";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newVehicle.getPlate());
            pstmt.setString(2, newVehicle.getType().toString());
            pstmt.executeUpdate();
            //this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Lista la tabla Vehicle de la bd
     *
     * @return Lista de vehiculos
     */
    @Override
    public List<Vehicle> list() {

        List<Vehicle> vehicles = new ArrayList<>();
        try {
            String sql = "SELECT VehiclePlate, type FROM Vehicle";
            //this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Vehicle newVehicle = new Vehicle();
                newVehicle.setPlate(rs.getString("VehiclePlate"));
                newVehicle.setType(Utilities.getInstance().string_to_enum(rs.getString("Type")));
                vehicles.add(newVehicle);
            }
            //this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vehicles;
    }
}
