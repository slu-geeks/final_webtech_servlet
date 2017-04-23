package com.finalproject.db;

import com.finalproject.model.UserAccount;

import java.sql.*;

/**
 * Created by s422 on 19/04/2017.
 */
public class DatabaseConnectivity {

    private static volatile Connection sqlConnection;
    private static volatile DatabaseConnectivity instance;
    public static final String DB_USERNAME = "root";
    public static final String DB_PASSWORD = "root";
    public static final String DB_NAME = "webtek-final";
    public static final String DB_HOST = "localhost";
    public static final String DB_PORT = "3306";


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

    private static synchronized Connection getConnection() {
        if (sqlConnection == null) {
            synchronized (DatabaseConnectivity.class) {
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
            }
        }

        return sqlConnection;
    }

    public boolean addUser(UserAccount userAccount) {
        try {
            String sql = "INSERT INTO user_account (username, password, address, first_name, last_name, middle_name, status, " +
                    "email_address, birthday, phone_number, role_id, user_picture) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement pstmt = getConnection().prepareStatement(sql);
            pstmt.setString(1, userAccount.getUsername());
            pstmt.setString(2,userAccount.getPassword());
            pstmt.setString(3,userAccount.getAddress());
            pstmt.setString(4,userAccount.getFirstName());
            pstmt.setString(5,userAccount.getLastName());
            pstmt.setString(6,userAccount.getMiddleName());
            pstmt.setInt(7, userAccount.getStatus());
            pstmt.setString(8, userAccount.getEmailAddress());
            pstmt.setDate(9, new Date(userAccount.getDateOfBirth().getTime()));
            pstmt.setString(10, userAccount.getPhoneNumber());
            pstmt.setInt(11, userAccount.getRoleId());
            pstmt.setBytes(12, userAccount.getUserPhoto());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
