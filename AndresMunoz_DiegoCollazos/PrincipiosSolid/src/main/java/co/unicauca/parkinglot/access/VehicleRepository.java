package co.unicauca.parkinglot.access;
/**
* +--------------------------------------------------------------------------------------+
* | DESCRIPCION: Repositorio para la conexión e instancia de la base de datos
* | ESTUDIANTE: Andrés david Muñoz Cerón - Diego Collazos Perafan 
* | FECHA: 17/11/2021
* +--------------------------------------------------------------------------------------+
*/
/*Librerías para la conexión y manejo con la base de datos */
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

/*Librerias Domain*/
import co.unicauca.parkinglot.domain.TypeEnum;
import co.unicauca.parkinglot.domain.Vehicle;
import co.unicauca.parkinglot.domain.service.Service;

/*Clase vehicleRepository*/
public class VehicleRepository implements IVehicleRepository {

    private Connection conn;

    /*Método que me lista el contenido de la base de datos*/
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

    /*Método insert, salva un nuevo elemento en la base de datos*/
    @Override
    public boolean save(Vehicle newVehiculo) {
        try {
            //Validate Vehicle
            if (newVehiculo == null || newVehiculo.getPlate() == null || newVehiculo.getType() == null) {
                return false;
            }
            //this.connect();

            //script para insercion en sqlite
            String sql = "INSERT INTO Vehicle ( Plate, Type ) "
                    + "VALUES ( ?, ? )";
            
            //Usa el script sql en la conexion con la base de datos
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newVehiculo.getPlate());
            pstmt.setString(2, newVehiculo.getType().toString());
            pstmt.executeUpdate();
            //this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    /* Método auxiliar para la inicialización de la base de datos*/
    public VehicleRepository () {
        initDatabase();
    }
    /*Inicialización de la base de datos y creación de la tabla vehicle*/
    private boolean initDatabase() {
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS Vehicle (\n"
                + "	Plate VARCHAR2 PRIMARY KEY,\n"
                + "	Type text NOT NULL\n"
                + ");";

        try {
            this.connect();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            //this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    /*Instancia la base de datos*/
    public boolean connect() {
        String url = "jdbc:sqlite::memory:";
        
        try {
            //Conecta con la base de datos sqlite
            conn = DriverManager.getConnection(url);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /*Desconecta la base de datos*/
    public boolean disconnect() {
        try {
            if (conn != null) {
                conn.close();
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
}