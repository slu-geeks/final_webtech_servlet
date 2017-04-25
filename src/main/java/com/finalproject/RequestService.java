package com.finalproject;

import com.finalproject.db.PetServiceRepository;
import com.finalproject.db.ServiceRequestRepository;
import com.finalproject.model.PetService;
import com.finalproject.model.UserAccount;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by mehdi on 4/19/17.
 */

@WebServlet("/request-service")
public class RequestService extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<PetService> petServices = PetServiceRepository.fetchPetServiceList();
        req.setAttribute("petServices", petServices);
        RequestDispatcher rd = req.getRequestDispatcher("services.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer serviceId = Integer.parseInt(req.getParameter("requestService"));
        UserAccount user = (UserAccount) req.getSession().getAttribute("activeUser");

        boolean isRequestedRegisered = ServiceRequestRepository.insertRequest(serviceId, user.getAccountId());
        req.setAttribute("isRequestRegistered", isRequestedRegisered);

        RequestDispatcher rd = req.getRequestDispatcher("services.jsp");
        rd.forward(req, resp);


    }
}
