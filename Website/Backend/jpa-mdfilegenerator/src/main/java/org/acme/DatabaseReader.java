package org.acme;

import org.acme.Main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.plaf.nimbus.State;
import javax.swing.text.html.parser.Entity;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.ConnectException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.acme.SelectedProduct;

public class DatabaseReader {
    public static void main(String[] args) {
    }

    public static int getAmountOfProducts(Connection con) throws SQLException {
        Statement stmt = con.createStatement();

        ResultSet rs1 = stmt.executeQuery("SELECT COUNT(*)FROM products.Products p ");

        int ammountofproducts = 0;

        while(rs1.next()){
            ammountofproducts = rs1.getInt(1);
        }
        return ammountofproducts;
    }

    public static String[] getProductNames(Connection con, int ammountofproducts) throws SQLException {
        Statement stmt = con.createStatement();
        String[] productnames = new String[ammountofproducts];
        int i = 0;

        ResultSet rs = stmt.executeQuery("SELECT * FROM products.Products p");

        while (rs.next()){
            productnames[i] = rs.getString("name");
            i += 1;
        }

        return productnames;
    }

    public static int getIdOfNewProduct(Connection con, int ammountofproducts) throws SQLException {
        Statement stmt = con.createStatement();
        int[] productids = new int[ammountofproducts];
        int newproductid;
        int i = 0;

        ResultSet rs = stmt.executeQuery("SELECT id FROM products.Products p");

        while (rs.next()){
            productids[i] = rs.getInt("id");
            i+= 1;
        }

        newproductid = productids[SelectedProduct.selectedproduct];

        return newproductid;
    }

    public static String getNameOfNewProduct(Connection con, int ammountofproducts) throws SQLException {
        Statement stmt = con.createStatement();
        String[] productnames = new String[ammountofproducts];
        String newproductname;
        int i = 0;

        ResultSet rs = stmt.executeQuery("SELECT * FROM products.Products p");

        while (rs.next()){
            productnames[i] = rs.getString("name");
            i += 1;
        }

        newproductname  = productnames[SelectedProduct.selectedproduct];

        return newproductname;
    }

    public static String getPriceOfNewProduct(Connection con, int ammountofproducts) throws SQLException {
        Statement stmt = con.createStatement();
        String[] productprices = new String[ammountofproducts];
        String newproductprice;
        int i = 0;

        ResultSet rs = stmt.executeQuery("SELECT * FROM products.Products p");

        while (rs.next()){
            productprices[i] = rs.getString("price");
            i += 1;
        }

        newproductprice = productprices[SelectedProduct.selectedproduct];

        return newproductprice;
    }

    public static String getLongDescriptionOfNewProduct(Connection con, int ammountofproducts) throws SQLException {
        Statement stmt = con.createStatement();
        String[] productlongdescriptions = new String[ammountofproducts];
        String newproductlongdescription;
        int i = 0;

        ResultSet rs = stmt.executeQuery("SELECT * FROM products.Products p");

        while (rs.next()){
            productlongdescriptions[i] = rs.getString("long description");
            i += 1;
        }

        newproductlongdescription = productlongdescriptions[SelectedProduct.selectedproduct];

        return newproductlongdescription;
    }

    public static String getShortDescriptionOfNewProduct(Connection con, int ammountofproducts) throws SQLException {
        Statement stmt = con.createStatement();
        String[] productshortdescriptions = new String[ammountofproducts];
        String newproductshortdescription;
        int i = 0;

        ResultSet rs = stmt.executeQuery("SELECT * FROM products.Products p");

        while (rs.next()){
            productshortdescriptions[i] = rs.getString("short description");
            i += 1;
        }

        newproductshortdescription = productshortdescriptions[SelectedProduct.selectedproduct];

        return newproductshortdescription;
    }
}
