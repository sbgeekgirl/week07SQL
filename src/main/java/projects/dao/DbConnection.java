package projects.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import projects.exception.DbException;

public class DbConnection {
    public static final String SCHEMA = "projects";
    public static final String USER = "projects";
    public static final String PASSWORD = "projects";
    public static final String HOST = "localhost";
    public static final int PORT = 3306;

    public static Connection getConnection(){
        String url = String.format("jdbc:mysql://%s:%d/%s?user=%s&password=%s&useSSL=false", HOST, PORT, SCHEMA, USER, PASSWORD);
        
        System.out.println("Connecting with url= " + url);

        try {
            Connection conn = DriverManager.getConnection(url);
            System.out.println("Successfully obtained connection!");
            return conn;
        } catch (SQLException e){
            throw new DbException(e);
        }
    }
}

