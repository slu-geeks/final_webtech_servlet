package com.finalproject.servlets;

import com.finalproject.beans.UserAccount;
import com.finalproject.db.UserAccountRepository;
import com.finalproject.util.LogoutUtils;
import org.apache.commons.io.IOUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by mehdi on 5/11/17.
 */

@WebServlet(name = "profile", urlPatterns = "/profile")
@MultipartConfig
public class Profile extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean isSessionAvailable = LogoutUtils.checkSession(req.getSession());
        if (!isSessionAvailable) {
            resp.sendRedirect("login");
            return;
        }

        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/pages/profile.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("Password");
        String repassword = req.getParameter("rePassword");
        String address = req.getParameter("address");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String middleInitial = req.getParameter("middleInitial");
        String emailAddress = req.getParameter("emailAddress");
        String phoneNumber = req.getParameter("phoneNumber");
        String dateOfBirth = req.getParameter("dateOfBirth");
        //TODO PUT SOME VALIDATION
        Date dayOfBirth = getDate(dateOfBirth);
        /*Part picturePart = req.getPart("personPicture");
        InputStream is = picturePart.getInputStream();
        byte[] bytes = IOUtils.toByteArray(is);
        */

        if(!repassword.equals(password)){
            req.setAttribute("passwordDoesntMatch", true);
            RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/pages/profile.jsp");
            rd.forward(req, resp);
            return;
        }

        UserAccount userAccount = new UserAccount(
                username, password, address, firstName, lastName, middleInitial,
                (short) 1, emailAddress, dayOfBirth, 1, phoneNumber, null
        );

        UserAccount sessionUser = (UserAccount )req.getSession().getAttribute("activeUser");
        userAccount.setAccountId(sessionUser.getAccountId());
        userAccount.setRoleId(sessionUser.getRoleId());

        UserAccountRepository.updateUserAccount(userAccount);

        req.getSession().setAttribute("activeUser", userAccount);

        req.setAttribute("updateSuccessful", true);
        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/pages/profile.jsp");
        rd.forward(req, resp);
        return;
    }

    private Date getDate(String dateStr) {
        if (dateStr == null || dateStr.isEmpty()) {
            return null;
        }
        DateFormat format = new SimpleDateFormat("MM-dd-yyyy", Locale.ENGLISH);
        Date date = null;
        try {
            date = format.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
