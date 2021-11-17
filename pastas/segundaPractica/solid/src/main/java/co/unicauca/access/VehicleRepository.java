package co.unicauca.access;


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

import co.unicauca.domain.TypeEnum;
import co.unicauca.domain.Vehicle;
import co.unicauca.domain.service.Service;

public class VehicleRepository implements IVehicleRepository{

    private Connection conn;

    public VehicleRepository(){
        initDatabase();
    }

    
    /** 
     * Save a new vehicle to DB
     * @param newVehiculo New Vehicle to be saved
     * @return boolean indicating method call success/failure 
     */
    @Override
    public boolean save(Vehicle newVehiculo) {
        try {
            if(newVehiculo == null){
                return false;
            }
    
            String sql = "INSERT INTO Vehicle( Plate, Type )"
                    + "VALUES ( ?,?)";
            PreparedStatement prepStatement = conn.prepareStatement(sql);
            prepStatement.setString(1, newVehiculo.getPlate());
            prepStatement.setString(2, newVehiculo.getType().toString());
            prepStatement.executeUpdate();
    
            return true;
        } catch (Exception e) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, e);
        }

        return false;
        
    }

    
    /** 
     * Method that returns a list filled with all the vehicles fetched from the DB
     * 
     * @return List<Vehicle> that contains all vehicles in DB
     */
    @Override
    public List<Vehicle> list() {
        List<Vehicle> vehicles = new ArrayList<>();

        try {
            String sql = "SELECT Plate, Type FROM Vehicle";

            Statement statement = conn.createStatement();

            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                Vehicle newVehicle = new Vehicle();
                newVehicle.setPlate(rs.getString("Plate"));
                newVehicle.setType(TypeEnum.valueOf(rs.getString("Type")));
                vehicles.add(newVehicle);
            }

        } catch (Exception ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vehicles;
    }
    /**
     * Initialize database
     */
    private void initDatabase(){
        String sql = "CREATE TABLE IF NOT EXISTS Vehicle (\n"
                + "	Plate text PRIMARY KEY,\n"
                + "	Type text NOT NULL \n"
                + ");";
        try {
            this.connect();
            Statement statement = conn.createStatement();
            statement.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Connect to Database
     */
    public void connect(){
        String url = "jdbc:sqlite::memory:";
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Disconnect from Database
     */
    public  void disconnect(){
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
