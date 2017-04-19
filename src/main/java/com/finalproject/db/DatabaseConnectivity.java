package com.finalproject.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by s422 on 19/04/2017.
 */
public class DatabaseConnectivity {

    private static volatile Connection sqlConnection;
    private static volatile DatabaseConnectivity instance;


    private DatabaseConnectivity() {
    }

    public static DatabaseConnectivity getInstance() {
        if (instance == null) {


            synchronized (DatabaseConnectivity.class) {
                if (instance == null) {
                    instance = new DatabaseConnectivity();
                }
            }
        }

        return instance;
    }

    public synchronized Connection getSqlConnection() {
        if (sqlConnection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                System.out.println("Where is your MySQL JDBC Driver?");
                e.printStackTrace();
                return null;
            }

            Connection connection = null;

            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/webtek-final", "root", "");
                sqlConnection = connection;

            } catch (SQLException e) {
                System.out.println("Connection Failed! Check output console");
                e.printStackTrace();
                return null;
            }
        }
        return sqlConnection;
    }
}
