package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Yael Arturo Chavoya Andalón 14300094
 */
public abstract class Controller {
    
    private static final String CONN_STRING = "jdbc:mysql://localhost:3306/libros";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    protected Connection connection;

    public Controller() {
         try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(CONN_STRING, USER, PASSWORD);
             System.out.println("WOOHOO");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }  
    
}
