package com.finalproject.servlets;

import com.finalproject.util.LogoutUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Jerome on 5/11/17.
 */
@WebServlet(name = "sp1", urlPatterns = "/sp1")
public class sp1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean isSessionAvailable = LogoutUtils.checkSession(req.getSession());
        if(!isSessionAvailable){
            resp.sendRedirect("login");
            return;
        }

        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/pages/sp1.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println();
    }
}
