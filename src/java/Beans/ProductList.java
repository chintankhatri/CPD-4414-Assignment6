/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Connect.Connect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import services.Chintan;

/**
 *
 * @author c0645743
 */
@Singleton
public class ProductList {

    @EJB
    Chintan service;
    public List<Product> productList;

    public ProductList() {
        Product product = new Product();

        try (Connection con = Connect.getConnection()) {
            String query = "SELECT * FROM product";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                product.productid = rs.getInt("productid");
                product.name = rs.getString("name");
                product.description = rs.getString("description");
                product.quantity = rs.getInt("quantity");

                productList.add(product);

            }

        } catch (SQLException ex) {
            
            Logger.getLogger(ProductList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void add(Product product) {

        newService.add(product.toJSON());
        productList.add(product);

    }

    public void remove(Product product) {

        int id = product.productID;
        newService.deleteById(String.valueOf(id));
        productList.remove(product);

    }

    public void remove(int id) {

        newService.deleteById(String.valueOf(id));

    }

    public void set(int id, Product product) {
        newService.updateData(String.valueOf(id), product.toJSON());

    }

    
    
    

}
