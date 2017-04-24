package com.finalproject;

import com.finalproject.db.DatabaseConnectivity;
import com.finalproject.db.UserAccountRepository;
import com.finalproject.model.UserAccount;
import com.finalproject.util.ValidatorUtil;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import org.apache.commons.io.IOUtils;

import javax.servlet.RequestDispatcher;
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
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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

    private static final String SIGN_UP_PAGE = "signup.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher(SIGN_UP_PAGE);
        rd.forward(req, resp);
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
        //TODO PUT SOME VALIDATION
        Date dayOfBirth = getDate(dateOfBirth);
        Part picturePart = req.getPart("personPicture");
        InputStream is = picturePart.getInputStream();
        byte[] bytes = IOUtils.toByteArray(is);


        UserAccount userAccount = new UserAccount(
                username, password, address, firstName, lastName, middleInitial,
                (short) 1, emailAddress, dayOfBirth, 1, phoneNumber, bytes
        );

        ValidatorUtil validatorUtil = new ValidatorUtil<UserAccount>(UserAccount.class);
        Set<ConstraintViolation<UserAccount>> violation = validatorUtil.checkValidation(userAccount);
        if (violation.size() != 0) {
            //tell user to fix his input

            List<String> errors = new ArrayList<String>();

            for (ConstraintViolation<UserAccount> each : violation) {
                errors.add(each.getMessage());
            }
            req.setAttribute("errors", errors);
            RequestDispatcher rd = req.getRequestDispatcher("signup.jsp");
            rd.forward(req, resp);
            return;
        }

        boolean isInserted = false;

        isInserted = UserAccountRepository.addUserAccount(userAccount);
        if (!isInserted) {
            req.setAttribute("errors", Arrays.asList("this username/email already exists"));
            RequestDispatcher rd = req.getRequestDispatcher("signup.jsp");
            rd.forward(req, resp);
        }else{
            resp.sendRedirect("login");
        }


    }


    private Date getDate(String dateStr) {
        if (dateStr == null || dateStr.isEmpty()) {
            return null;
        }
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date date = null;
        try {
            date = format.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
