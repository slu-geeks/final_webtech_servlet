package com.finalproject;

import com.finalproject.db.DatabaseConnectivity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

/**
 * @author Mehdi Afsari Kashi
 * @version 1.0.0
 *          <p>
 *          Creation Date: 2017/02/14
 * @since 1.0.0
 */
public class Signup extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String address = req.getParameter("address");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String middleInitial = req.getParameter("middleInitial");
        String emailAddress = req.getParameter("emailAddress");
        String age = req.getParameter("age");
        String phoneNumber = req.getParameter("phoneNumber");
        String dateOfBirth = req.getParameter("dateOfBirth");

        DatabaseConnectivity db = DatabaseConnectivity.getInstance();

        Connection connection = db.getSqlConnection();


    }
}
