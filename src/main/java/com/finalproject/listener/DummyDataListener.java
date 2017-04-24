package com.finalproject.listener;

import com.finalproject.db.DatabaseConnectivity;
import com.finalproject.db.UserAccountRepository;
import com.finalproject.model.UserAccount;

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
        trancateAllTables();
        addData();
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
        addSomeDummyRoles();
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
        for(int i = 0; i< 10; i++){
            UserAccountRepository.addUserAccount(new UserAccount(
                    randomStr(),randomStr(),randomStr(),randomStr(),randomStr(),randomStr(),(short)1,randomStr(),
                    new Date(), 1, "090623545"+randomInt(10, 99), null
            ));
        }
    }

    private void addSomeDummyPetService() {

    }

    private void addSomeDummyFeedbacks() {

    }

    private void addSomeDummyServiceRequest() {

    }

    private String randomStr(){
        return UUID.randomUUID().toString().substring(0,5);
    }

    private int randomInt(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

}
