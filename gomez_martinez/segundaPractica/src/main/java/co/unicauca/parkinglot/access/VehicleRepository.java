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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author angiecgomez
 * @author mafemartinez
 */
public class VehicleRepository implements IVehicleRepository {

    /**
     * Attributes
     */
    private Connection conn;

    /**
     * Constructor
     */
    public VehicleRepository() {
        initDatabase();
    }

    /**
     * Methods
     */
    
    /**
     * Save a new Vehicle in Database
     * @param newVehicle
     * @return boolean, indicates if the operation was successful or not
     */
    @Override
    public boolean save(Vehicle newVehicle) {

        if (newVehicle == null) {
            return false;
        }

        try {
            String sql = "INSERT INTO Vehicle(plate, type) VALUES(?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newVehicle.getPlate());
            pstmt.setString(2, newVehicle.getType().toString());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(VehicleRepository.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    /**
     * Calls the list of vehicles from the database
     * @return vehicles' list
     */
    @Override
    public List<Vehicle> list() {

        List<Vehicle> vehicles = new ArrayList<>();
        try {
            String sql = "SELECT plate, type FROM Vehicle";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                Vehicle newVehicle = new Vehicle();
                newVehicle.setPlate(rs.getString("plate"));
                newVehicle.setType(TypeEnum.valueOf(rs.getString("type")));
                vehicles.add(newVehicle);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VehicleRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vehicles;
    }

    /**
     * Inizialite Database
     */
    private void initDatabase() {

        String sql
                = "CREATE TABLE IF NOT EXISTS Vehicle (\n"
                + "plate TEXT PRIMARY KEY,\n"
                + "type TEXT NOT NULL\n);";

        try {
            this.connect();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(VehicleRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Connect to Database
     */
    private void connect() {

        String url = "jdbc:sqlite::memory:";

        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            Logger.getLogger(VehicleRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Disconnect to the Database
     */
    private void disconnect() {

        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(VehicleRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
