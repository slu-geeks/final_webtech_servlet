package com.finalproject.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by s422 on 19/04/2017.
 */
public class DatabaseConnectivity {

    private static volatile Connection sqlConnection;
    public static final String DB_USERNAME = "root";
    public static final String DB_PASSWORD = "mysqlmysql";
    public static final String DB_NAME = "webtek-final";
    public static final String DB_HOST = "localhost";
    public static final String DB_PORT = "3306";


    private DatabaseConnectivity() {
    }

    public static synchronized Connection getConnection() {
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
                connection = DriverManager.getConnection(String.format("jdbc:mysql://%s:%s/%s", DB_HOST, DB_PORT, DB_NAME), DB_USERNAME, DB_PASSWORD);
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
