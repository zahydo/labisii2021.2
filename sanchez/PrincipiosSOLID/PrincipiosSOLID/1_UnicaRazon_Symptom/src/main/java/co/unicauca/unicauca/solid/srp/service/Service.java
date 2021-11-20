package co.unicauca.unicauca.solid.srp.service;

import co.unicauca.unicauca.solid.srp.domain.Product;
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
 * Servicio es la clase que concentra la lógica de negocio
 *
 * @author libardo Docs Sqlite; https://www.sqlitetutorial.net/sqlite-java/
 */
public class Service {

    private Connection conn;

    public Service() {
        initDatabase();
    }

    // Razon 1: A futuro podria cambiar la lógica para calcular el impuesto
    
    /**
     * Una lógica de negocio sencilla: validad datos y calcular un impouesto del
     * producto
     *
     * @param product
     * @return
     */
    public double calculateProductTax(Product product) {

        //Validate product.
        if (product == null) {
            return 0;
        }
        double TAX = 0.19d;
        double productTax = product.getPrice() * TAX;
        return productTax;
    }

    // Razon 2: A futuro podriamos cambiar el motor de base de datosm usar un 
    // ORM, o cambiar la estructura de la base de datos
    /**
     * Lógica de acceso a datos
     *
     * @param newProduct producto a ser almacenado en la base de datos
     * @return true si fue posible guardar el producto, false en caso contrario
     */
    public boolean saveProduct(Product newProduct) {

        try {
            //Validate product
            if (newProduct == null || newProduct.getId() < 0 || newProduct.getName().isBlank()) {
                return false;
            }

            String sql = "INSERT INTO Product ( ProductId, Name, Price ) "
                    + "VALUES ( ?, ?, ? )";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, newProduct.getId());
            pstmt.setString(2, newProduct.getName());
            pstmt.setDouble(3, newProduct.getPrice());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public List<Product> listProducts() {
        List<Product> products = new ArrayList<>();
        try {

            String sql = "SELECT ProductId, Name, Price FROM Product";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Product newProduct = new Product();
                newProduct.setId(rs.getInt("ProductId"));
                newProduct.setName(rs.getString("Name"));
                newProduct.setPrice(rs.getDouble("Price"));

                products.add(newProduct);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    private void initDatabase() {
        // SQLite connection string
        //String url = "jdbc:sqlite:./mydatabase.db";
        String url = "jdbc:sqlite::memory:";

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS Product (\n"
                + "	ProductId integer PRIMARY KEY,\n"
                + "	Name text NOT NULL,\n"
                + "	Price real\n"
                + ");";

        try {
            conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            stmt.execute(sql);

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
