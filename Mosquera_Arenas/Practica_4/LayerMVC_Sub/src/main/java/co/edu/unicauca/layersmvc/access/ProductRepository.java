/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.layersmvc.access;

import co.unicauca.layersmvc.commons.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author David E
 */
public class ProductRepository implements IProductRepository{
    
    private Connection conn;
    
    public ProductRepository() {

    }
    
    @Override
    public boolean save(Product producto) {
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
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, "Error al insertar el registro", ex);
        }
        return false;
    }

    @Override
    public boolean update(Product producto) {
        try {
            this.connect();
            String SQL = "UPDATE Producto SET nombre='"+producto.getName()+"',valor="+producto.getPrice()
                + "WHERE id="+producto.getProductId();
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.executeUpdate();
            pstmt.close();
            this.disconnect();
            return true;
        } catch (Exception e) {
        }
        return false;
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
            //String url = "jdbc:mysql:memory";
            String username = "root";
            String pwd = "12345678";
            conn = DriverManager.getConnection(url, username, pwd);
            System.out.println("Connected!!!!!");
            return 1;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, "Error al consultar Customer de la base de datos", ex);
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
            Logger.getLogger(ProductRepository.class.getName()).log(Level.FINER, "Error al cerrar Connection", ex);
        }
    }
    
}
