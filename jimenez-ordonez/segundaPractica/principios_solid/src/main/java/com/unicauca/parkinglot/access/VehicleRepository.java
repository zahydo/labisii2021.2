package com.unicauca.parkinglot.access;

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

import com.unicauca.parkinglot.domain.TypeEnum;
import com.unicauca.parkinglot.domain.Vehicle;
import com.unicauca.parkinglot.domain.service.Service;

public class VehicleRepository implements IVehicleRepository {
    
    private Connection conn;

    public VehicleRepository() {
        initDatabase();
    }

    
    /** 
     * Recibe un vehiculo para ser almacenado en la base de datos sqlite y si se
     * agrego almaceno exitosamente
     * @param newVehicle
     * @return boolean
     */
    @Override
    public boolean save(Vehicle newVehicle) {
        try {
            if (newVehicle.getPlate().isEmpty()) {
                return false;
            }
            String varInsert = "INSERT INTO Vehicle ( PLATE, TYPE ) " + "VALUES ( ?, ?)";
            PreparedStatement varPreState = conn.prepareStatement(varInsert);
            varPreState.setString(1, newVehicle.getPlate());
            varPreState.setString(2, String.valueOf(newVehicle.getType()));
            varPreState.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    
    /** 
     * Retorna la lista de vehiculos almacenados en la base de datos, vacia si 
     * la consulta no tiene rows
     * @return List<Vehicle>
     */
    @Override
    public List<Vehicle> list() {
        List<Vehicle> vehiculos = new ArrayList<>();
        try {
            String varSelect = "SELECT PLATE, TYPE FROM VEHICLE";
            Statement varState = conn.createStatement();
            ResultSet varResSet = varState.executeQuery(varSelect);
            while (varResSet.next()) {
                Vehicle newVehicle = new Vehicle();
                newVehicle.setPlate(varResSet.getString("PLATE"));
                newVehicle.setType(TypeEnum.valueOf(varResSet.getString("TYPE")));
                vehiculos.add(newVehicle);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vehiculos;
    }


    /**
     * Crea la estuctura de la based de datos aunque no exista
     */
    private void initDatabase() {
        String varTable = "CREATE TABLE IF NOT EXISTS VEHICLE (\n" + "	PLATE TEXT NOT NULL,\n"
                + "	TYPE TEXT NOT NULL\n" + ");";
        try {
            this.connect();
            Statement varState = conn.createStatement();
            varState.execute(varTable);

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    /**
     * Conecta con la base de datos
     */
    public void connect() {
        String varURL = "jdbc:sqlite::memory:";

        try {
            conn = DriverManager.getConnection(varURL);

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    /**
     * Desconecta la base de datos si existe
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
