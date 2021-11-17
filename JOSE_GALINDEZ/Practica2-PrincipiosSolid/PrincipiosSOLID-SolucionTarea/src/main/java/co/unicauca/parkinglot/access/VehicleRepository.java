/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.access;

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
 * Implentación del repositorio de vehiculos
 * Permite la conexion con la BD
 * @author Jose_R
 */
public class VehicleRepository implements IVehicleRepository {
    //Conexion con la BD
    private Connection conn;

    /**
     * Constructor del repositorio
     * inicia la conexion con la base de datos
     */
    public VehicleRepository() {
        initDatabase();
    }

    /**
     * Guarda el vehiculo en la BD
     * @param newVehicle vehiculo a ser almacenado en la DB
     * @return true si se guardo con exito, false en caso contrario
     */
    @Override
    public boolean save(Vehicle newVehicle) {
        try {
            //Validate product
            if (newVehicle == null || newVehicle.getPlate().isEmpty() || newVehicle.getType() == null) {
                return false;
            }
            //this.connect();
            String sql = "INSERT INTO Vehicle ( Plate, Type ) "
                    + "VALUES ( ?, ?)";

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
     * Realiza una lista de los vehiculos guardados en la DB
     * @return lista de vehiculos almacenados en la BD
     */
    @Override
    public List<Vehicle> list() {
        List<Vehicle> vehicles = new ArrayList<>();
        try {

            String sql = "SELECT Plate, Type FROM Vehicle";
            //this.connect();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Vehicle newVehicle = new Vehicle();
                newVehicle.setPlate(rs.getString("Plate"));
                newVehicle.setType(TypeEnum.valueOf(rs.getString("Type")));

                vehicles.add(newVehicle);
            }
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vehicles;
    }
    /**
     * Crea la conexion con la DB
     */
    private void initDatabase() {
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS Vehicle (\n"
                + "	Plate text PRIMARY KEY,\n"
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
    /**
     * Realiza la conexion con la DB
     */
    public void connect() {
        // SQLite connection string
        //String url = "jdbc:sqlite:./mydatabase.db";
        String url = "jdbc:sqlite::memory:";

        try {
            conn = DriverManager.getConnection(url);

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Termina la conexion con la BD
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

}
