package com.finalproject;

import com.finalproject.db.DatabaseConnectivity;
import com.finalproject.model.UserAccount;
import com.finalproject.util.ValidatorUtil;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.validation.ConstraintViolation;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.util.Set;

/**
 * @author Mehdi Afsari Kashi
 * @version 1.0.0
 *          <p>
 *          Creation Date: 2017/02/14
 * @since 1.0.0
 */

@WebServlet(name = "signup", urlPatterns = {"/signup"})
@MultipartConfig
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
        Part picturePart = req.getPart("personPicture");

        InputStream is = picturePart.getInputStream();
        byte[] bytes = IOUtils.toByteArray(is);

        DatabaseConnectivity db = DatabaseConnectivity.getInstance();
        UserAccount userAccount = new UserAccount(
                username, password, address, firstName, lastName, middleInitial,
                (short) 1, emailAddress, new Date(1), 1, phoneNumber, bytes
        );

        ValidatorUtil validatorUtil = new ValidatorUtil<UserAccount>(UserAccount.class);
        Set<ConstraintViolation<UserAccount>> violation = validatorUtil.checkValidation(userAccount);
        if(violation.size() != 0){
            //tell user to fix his input
            return;
        }

        boolean isInserted = db.addUser(userAccount);


    }


}
