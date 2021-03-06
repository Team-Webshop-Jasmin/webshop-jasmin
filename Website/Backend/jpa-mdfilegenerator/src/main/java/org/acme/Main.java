package org.acme;
import java.awt.desktop.ScreenSleepEvent;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import static java.sql.DriverManager.getConnection;
import static java.sql.DriverManager.println;
import org.acme.DatabaseReader;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.crypto.Data;

public class Main {

    public static void main(String[] args) throws IOException, SQLException {
        String fs ="";
        String fileContent = fileReader(fs);

        listAllProducts();
        String newfileContent = searchAndReplace(fileContent);
        fileWriter(newfileContent);
    }

    public static String fileReader(String fc) throws FileNotFoundException {
        File file = new File("mdtemplate.md");
        Scanner scan = new Scanner(file);

        while (scan.hasNextLine()) {
            fc = fc.concat(scan.nextLine() + "\n");
        }

        return fc;
    }
    public static Writer fileWriter(String fileContent) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        System.out.println("Path where file will be saved:");
        String filepath = reader.readLine();
        System.out.println("Name of new product:");
        String filename = reader.readLine();
        FileWriter writer = new FileWriter(filepath + "\\" + filename + ".md");

        writer.write(fileContent);
        writer.close();

        return writer;
    }

    public static String searchAndReplace (String fc) throws SQLException, IOException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306","root", "my-secret-pw");
        int ammountofproducts = DatabaseReader.getAmountOfProducts(con);

        String id = String.valueOf(DatabaseReader.getIdOfNewProduct(con, ammountofproducts));
        String name = DatabaseReader.getNameOfNewProduct(con, ammountofproducts);
        String price = DatabaseReader.getPriceOfNewProduct(con,ammountofproducts);
        String longdescription = DatabaseReader.getLongDescriptionOfNewProduct(con, ammountofproducts);
        String shortdescription = DatabaseReader.getShortDescriptionOfNewProduct(con, ammountofproducts);

        fc = fc.replace("%%ID%%", id);
        fc = fc.replace("%%TITLE%%", name);
        fc = fc.replace("%%PRICE%%", price);
        fc = fc.replace("%%LONGDESCRIPTION%%", longdescription);
        fc = fc.replace("%%SHORTDESCRIPTION%%", shortdescription);

        return fc;
    }

    public static int selectProductToAdd() throws IOException {
        int productselector = 0;
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        System.out.println("Which product do you wanna create a .md file for?");
        productselector = Integer.parseInt(reader.readLine());

        return productselector;
    }

    public static void listAllProducts() throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306","root", "my-secret-pw");
        int ammountofproducts = DatabaseReader.getAmountOfProducts(con);
        String[] productnames = DatabaseReader.getProductNames(con, ammountofproducts);

        for (int i = 0; i< productnames.length; i++){
            System.out.println(i+ "." + productnames[i]);
        }
    }
}

