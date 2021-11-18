/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.access;

import co.unicauca.parkinglot.domain.TypeEnum;
import co.unicauca.parkinglot.domain.Vehicle;
import java.security.Provider.Service;
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
 * @author Kevin Daryany Morales
 */
public class VehicleRepository implements IVehicleRepository{
     private Connection conn;

    public VehicleRepository() {
        initDatabase();
    }

    @Override
    /**
     * Guarda vehiculo
     */
    public boolean save(Vehicle newVehicule) {

        try {
            //Validate product
            if (newVehicule == null || newVehicule.getPlate().isEmpty()) {
                return false;
            }
            this.connect();

            String sql = "INSERT INTO Vehicle ( Plate, Type ) "
                    + "VALUES ( ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newVehicule.getPlate());
            pstmt.setString(2, newVehicule.getType().name());
            pstmt.executeUpdate();
            pstmt.close();
            this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
 /**
  * Elimina vehiculo 
  */
    public boolean removeVehicle(){
        try {
            this.connect();
            String sql = "DELETE FROM Vehicle";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    @Override
    public List<Vehicle> list() {
        List<Vehicle> products = new ArrayList<>();
        try {

            String sql = "SELECT * FROM Vehicle;";
            this.connect();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Vehicle newVehicle = new Vehicle();
                newVehicle.setPlate(rs.getString("Plate"));
                newVehicle.setType(TypeEnum.valueOf(rs.getString("Type")));
                products.add(newVehicle);
            }
            this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    private void initDatabase() {
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS Vehicle(\n"
                + "	Plate text PRIMARY KEY,\n"
                + "	Type text NOT NULL\n"
                + ");";

        try {
            this.connect();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
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
   /**
    *  cierra el sql
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
