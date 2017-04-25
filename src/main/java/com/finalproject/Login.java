package com.finalproject;

import com.finalproject.db.UserAccountRepository;
import com.finalproject.exceptions.NoRoleException;
import com.finalproject.exceptions.UserPasswordException;
import com.finalproject.model.UserAccount;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mehdi on 4/24/17.
 */

@WebServlet(name = "login", urlPatterns = {"/login"})
public class Login extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");


        List<String> errors = new ArrayList<>();

        if(username == null || username.isEmpty()){
            errors.add("your username should not be empty");
        }

        if(password == null || password.isEmpty()){
            errors.add("your password should not be empty");
        }

        if(!errors.isEmpty()){
            doDispatch(errors, req, resp);
            return;
        }

        UserAccount user = null;
        try {
            user = UserAccountRepository.fetchUser(username, password);
        } catch (UserPasswordException e) {
            doDispatch(Arrays.asList(e.getMessage()), req, resp);
        } catch (NoRoleException e) {
            doDispatch(Arrays.asList(e.getMessage()), req, resp);
        }

        if(user == null){
            doDispatch(Arrays.asList("the account you are requesting does not exist"), req, resp);
            return;
        }

        req.getSession().setAttribute("activeUser",user);
        resp.sendRedirect("dashboard");
    }

    private void doDispatch(List<String> errors, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("errors", errors);
        RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
        rd.forward(req, resp);
        return;
    }
}
