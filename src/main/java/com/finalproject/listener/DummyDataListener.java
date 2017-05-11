package com.finalproject.listener;

import com.finalproject.db.DatabaseConnectivity;
import com.finalproject.db.UserAccountRepository;
import com.finalproject.beans.UserAccount;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.*;
import java.util.*;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by mehdi on 4/24/17.
 */
@WebListener
public class DummyDataListener implements ServletContextListener {
    Connection connection = DatabaseConnectivity.getConnection();

    public void contextInitialized(ServletContextEvent sce) {
        //trancateAllTables();
        //addData();
    }

    public void contextDestroyed(ServletContextEvent sce) {

    }


    private void trancateAllTables() {
        try {
            Statement roleStatement = connection.createStatement();
            roleStatement.executeUpdate("SET FOREIGN_KEY_CHECKS = 0; ");
            roleStatement.executeUpdate("TRUNCATE role ");
            roleStatement.executeUpdate("SET FOREIGN_KEY_CHECKS = 1;");

            Statement userStatement = connection.createStatement();
            userStatement.executeUpdate("SET FOREIGN_KEY_CHECKS = 0; ");
            userStatement.executeUpdate("TRUNCATE TABLE " + "user_account");
            userStatement.executeUpdate("SET FOREIGN_KEY_CHECKS = 1;");


            Statement petServiceStatement = connection.createStatement();
            petServiceStatement.executeUpdate("SET FOREIGN_KEY_CHECKS = 0; ");
            petServiceStatement.executeUpdate("TRUNCATE TABLE " + "pet_service");
            petServiceStatement.executeUpdate("SET FOREIGN_KEY_CHECKS = 1;");


            Statement feedbackStatement = connection.createStatement();
            feedbackStatement.executeUpdate("SET FOREIGN_KEY_CHECKS = 0; ");
            feedbackStatement.executeUpdate("TRUNCATE TABLE " + "feedback");
            feedbackStatement.executeUpdate("SET FOREIGN_KEY_CHECKS = 1;");

            Statement serviceRequestStatement = connection.createStatement();
            serviceRequestStatement.executeUpdate("SET FOREIGN_KEY_CHECKS = 0; ");
            serviceRequestStatement.executeUpdate("TRUNCATE TABLE " + "service_request");
            serviceRequestStatement.executeUpdate("SET FOREIGN_KEY_CHECKS = 1;");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void addData() {
        //addSomeDummyRoles();
        addSomeDummyCustomers();
        addSomeDummyPetService();
        addSomeDummyFeedbacks();
        addSomeDummyServiceRequest();
    }


    private void addSomeDummyRoles() {
        String sql = "INSERT INTO role (role_id, role_name, description) VALUES (?,?,?)";
        try {
            PreparedStatement pstmt = DatabaseConnectivity.getConnection().prepareStatement(sql);
            pstmt.setInt(1, 1);
            pstmt.setString(2, "customer");
            pstmt.setString(3, "Customer role with limited access right");
            pstmt.executeUpdate();

            PreparedStatement pstmt2 = DatabaseConnectivity.getConnection().prepareStatement(sql);
            pstmt2.setInt(1, 2);
            pstmt2.setString(2, "service provider");
            pstmt2.setString(3, "service provider role with servicing right");
            pstmt2.executeUpdate();

            PreparedStatement pstmt3 = DatabaseConnectivity.getConnection().prepareStatement(sql);
            pstmt3.setInt(1, 3);
            pstmt3.setString(2, "admin");
            pstmt3.setString(3, "admin role with admin access right");
            pstmt3.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addSomeDummyCustomers() {
        for (int i = 0; i < 10; i++) {
            UserAccountRepository.addUserAccount(new UserAccount(
                    randomStr(), randomStr(), randomStr(), randomStr(), randomStr(), randomStr(), (short) 1, randomStr(),
                    new Date(), 1, "090623545" + randomInt(10, 99), null
            ));
        }
    }

    private void addSomeDummyPetService() {

        for (int i = 0; i < 10; i++) {
            String sql = "INSERT INTO pet_service (service_name, service_description, service_price, service_duration_from, service_duration_to, service_picture, sp_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try {
                PreparedStatement pstmt = DatabaseConnectivity.getConnection().prepareStatement(sql);
                pstmt.setString(1, randomStr());
                pstmt.setString(2, randomStr());
                pstmt.setInt(3, randomInt(100, 500));
                pstmt.setDate(4, new java.sql.Date(getDateNdaysBefore(randomInt(5, 10)).getTime()));
                pstmt.setDate(5, new java.sql.Date(new Date().getTime()));
                pstmt.setString(6, null);
                pstmt.setInt(7, 11);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    private void addSomeDummyFeedbacks() {
        for (int i = 0; i < 10; i++) {
            String sql = "INSERT INTO feedback (" +
                    "request_id, ranking, contacting_phone_number, feedback_messages, feedback_date, " +
                    "consideration_date, feedback_status, checked_description) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            try {
                PreparedStatement pstmt = DatabaseConnectivity.getConnection().prepareStatement(sql);
                pstmt.setInt(1, randomInt(1,10));
                pstmt.setInt(2, randomInt(1,10));
                pstmt.setString(3, "090626522" + randomInt(10, 99));
                pstmt.setString(4, randomStr());
                pstmt.setDate(5, new java.sql.Date(getDateNdaysBefore(randomInt(10, 25)).getTime()));
                pstmt.setDate(6, null);
                pstmt.setInt(7, (short)1);
                pstmt.setString(8, null);
                pstmt.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void addSomeDummyServiceRequest() {
        for (int i = 0; i < 10; i++) {
            String sql = "INSERT INTO service_request (start_servicing, end_servicing, request_status, service_id, account_id, sp_id) VALUES (?, ?, ?, ?, ?, ?)";
            try {
                PreparedStatement pstmt = DatabaseConnectivity.getConnection().prepareStatement(sql);

                pstmt.setDate(1, new java.sql.Date(getDateNdaysBefore(randomInt(10, 25)).getTime()));
                pstmt.setDate(2, new java.sql.Date(getDateNdaysBefore(randomInt(2, 9)).getTime()));
                pstmt.setInt(3, 1);
                pstmt.setInt(4, randomInt(1, 10));
                pstmt.setInt(5, randomInt(1, 10));
                pstmt.setInt(6, randomInt(1, 10));
                pstmt.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private String randomStr() {
        return UUID.randomUUID().toString().substring(0, 5);
    }

    private int randomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    private Date getDateNdaysBefore(int nDayBefore) {
        long DAY_IN_MS = 1000 * 60 * 60 * 24;
        return new Date(System.currentTimeMillis() - (nDayBefore * DAY_IN_MS));
    }

}
