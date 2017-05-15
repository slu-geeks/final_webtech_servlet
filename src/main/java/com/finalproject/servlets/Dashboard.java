package com.finalproject.servlets;

import com.finalproject.db.PetServiceRepository;
import com.finalproject.beans.ProviderService;
import com.finalproject.util.LogoutUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by mehdi on 4/24/17.
 */

@WebServlet(name = "dashboard", urlPatterns = {"/dashboard"})
public class Dashboard extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean isSessionAvailable = LogoutUtils.checkSession(req.getSession());
        if(!isSessionAvailable){
            RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/pages/login.jsp");
            rd.forward(req, resp);
            return;
        }

        //show all available services to the user
        List<ProviderService> serviceList = PetServiceRepository.fetchPetServiceList();
        req.setAttribute("serviceAvailable", serviceList);

        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/pages/dashboard.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
