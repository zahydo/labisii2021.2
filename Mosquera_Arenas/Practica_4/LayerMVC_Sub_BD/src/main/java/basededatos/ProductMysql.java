package basededatos;


import co.unicauca.layersmvc.commons.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Repositorio de Clientes en MySWL
 *
 * @author Libardo, Julio
 */
public class ProductMysql {

    /**
     * Conección con Mysql
     */
    private Connection conn;

    public ProductMysql() {

    }
    /**
     * Busca en la bd un customer
     * @param id cedula
     * @return objeto customer, null si no lo encuentra
     */
    public Product findProduct(String id) {
        Product producto = null;

        this.connect();
        try {
            String sql = "SELECT * from Producto where id=? ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            ResultSet res = pstmt.executeQuery();
            if (res.next()) {
                producto = new Product();
                producto.setProductId(Integer.parseInt(res.getString("id")));
                producto.setName(res.getString("nombre"));
                producto.setPrice(Integer.parseInt(res.getString("valor")));
            }
            pstmt.close();
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(ProductMysql.class.getName()).log(Level.SEVERE, "Error al consultar Customer de la base de datos", ex);
        }
        return producto;
    }
    
    public int update(Product producto){
        try {
            this.connect();
            String SQL = "UPDATE Producto SET nombre='"+producto.getName()+"',valor="+producto.getPrice()
                + "WHERE id="+producto.getProductId();
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.executeUpdate();
            pstmt.close();
            this.disconnect();
        } catch (Exception e) {
        }
        return producto.getProductId();
    }

    public int createProduct(Product producto) {
        
        try {

            this.connect();
            String sql = "INSERT INTO Producto(id, nombre, valor) VALUES (?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, String.valueOf(producto.getProductId()));
            pstmt.setString(2, producto.getName());
            pstmt.setString(3, String.valueOf(producto.getPrice()));
            
            pstmt.executeUpdate();
            pstmt.close();
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(ProductMysql.class.getName()).log(Level.SEVERE, "Error al insertar el registro", ex);
        }
        return producto.getProductId();

    }

    /**
     * Permite hacer la conexion con la base de datos
     *
     * @return
     */
    public int connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //crea una instancia de la controlador de la base de datos
            String url = "jdbc:mysql://localhost:3307/agency";
            String username = "root";
            String pwd = "12345678";
            conn = DriverManager.getConnection(url, username, pwd);
            System.out.println("Connected!!!!!");
            return 1;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ProductMysql.class.getName()).log(Level.SEVERE, "Error al consultar Customer de la base de datos", ex);
        }
        return -1;
    }

    /**
     * Cierra la conexion con la base de datos
     *
     */
    public void disconnect() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductMysql.class.getName()).log(Level.FINER, "Error al cerrar Connection", ex);
        }
    }

}
