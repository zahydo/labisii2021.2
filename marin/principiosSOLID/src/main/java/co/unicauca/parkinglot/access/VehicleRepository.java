
package co.unicauca.parkinglot.access;

import co.unicauca.parkinglot.domain.TypeEnum;
import co.unicauca.parkinglot.domain.Vehicle;
import co.unicauca.parkinglot.domain.service.Service;
import static java.awt.SystemColor.TEXT;
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
 * @authores Fabián David Marín(fabianxd0496@unicauca.edu.co) 
 *           Hector Fernando Dorado(hfdorado@unicauca.edu.co)
 *           Juan Sebastian Sánchez Pizo(spjuan@unicauca.edu.co)
 */
public class VehicleRepository implements IVehicleRepository {

    private Connection conn;

    public VehicleRepository() {
        initDatabase();
    }

    /**
     *
     * Metodo para guardar un nuevo vehiculo en la Base de datos, en este caso
     * la tabla DataBase
     */
    @Override
    public boolean save(Vehicle newVehiculo) {

        try {
            //Validacion del RegistroVehiculo
            if (newVehiculo == null
                    || newVehiculo.getPlate().isBlank()
                    || newVehiculo.getType() == null) {
                return false;

            }
            //this.connect();
            String sql = "INSERT INTO DataBase ( Plate, Type) "
                    + "VALUES ( ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newVehiculo.getPlate());
            pstmt.setObject(2, newVehiculo.getType());
            pstmt.executeUpdate();
            //this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Vehicle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Crea la lista de vehiculos con los datos que tenga la Tabla DataBase
     */
    @Override
    public List<Vehicle> list() {
        List<Vehicle> vehiculos = new ArrayList<>();
        try {

            String sql = "SELECT Plate, Type FROM DataBase";
//            this.connect();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Vehicle newVehiculo = new Vehicle();
                newVehiculo.setPlate(rs.getString("Plate"));
                newVehiculo.setType(TypeEnum.valueOf(rs.getString("Type")));
                vehiculos.add(newVehiculo);
            }
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(VehicleRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vehiculos;
    }

    /**
     *
     * Metodo para obtener algun vehiculo por Placa
     */
    public Vehicle obtenerVehiculo(String placa) {
        List<Vehicle> vehiculos = new ArrayList<>();
        vehiculos = this.list();
        String str;
        for (int i = 0; i < vehiculos.size(); i++) {
            str = vehiculos.get(i).getPlate();
            if (str.compareTo(placa) == 0) {

                Vehicle v = vehiculos.get(i);
                return v;
            }
        }
        return null;
    }

    /**
     * Inicia la Base de datos, en este caso se crea una tabla con dos columnas
     * (Placa y Tipo de Vehiculo)
     */
    private void initDatabase() {

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS DataBase (\n"
                + "	Plate text PRIMARY KEY,\n"
                + "      Type varchar2 NOT NULL)";
        Statement stmt = null;
        try {
            this.connect();
            stmt = conn.createStatement();
            stmt.execute(sql);
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(Vehicle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Conectar la Base de datos
     */
    public void connect() {
        String url = "jdbc:sqlite::memory:";
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            Logger.getLogger(Vehicle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Desconectar la Base de datos
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
