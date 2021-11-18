/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Control del repositorio de Vehiculo
 * @fecha 2021/11/17
 * @author Miguel Mosquera, Sebastian Arenas
 */
public class VehicleRepository implements IVehicleRepository{
    
    private Connection conn;    //Almacena el estado de la base de Datos
    
    /** 
     * Retorna una instancia de esta clase 
     * @return RepositoryFactory instance
     */
    public VehicleRepository(){
        initDatabase();
    }
    
    @Override
    public boolean save(Vehicle vehiculo) {
        try {
            this.connect();

            String sql = "INSERT INTO Vehicle ( VehiclePlate, Type) "
                    + "VALUES (?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            
           
            pstmt.setString(1, vehiculo.getPlate());
            pstmt.setString(2, vehiculo.getType().toString());
            pstmt.executeUpdate();
            
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
            String sql = "SELECT VehiclePlate, type FROM Vehicle";
            this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                Vehicle newVehicle = new Vehicle();
                newVehicle.setPlate(rs.getString("VehiclePlate"));
                newVehicle.setType(Utilities.getInstance().string_to_enum(rs.getString("Type")));
                vehicles.add(newVehicle);
            }
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vehicles;
    }
    
    /** 
     * Inicializa la Base de Datos 
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
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    /** 
     * Conecta la Base de Datos
     */
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
     * Desconecta la base de datos
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
