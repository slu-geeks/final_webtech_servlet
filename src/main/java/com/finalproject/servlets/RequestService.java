package com.finalproject.servlets;

import com.finalproject.beans.ProviderService;
import com.finalproject.beans.UserAccount;
import com.finalproject.db.PetServiceRepository;
import com.finalproject.db.RequestRepository;
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
 * Created by mehdi on 5/11/17.
 */

@WebServlet(name="request-service", urlPatterns = "/request-service")
public class RequestService extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean isSessionAvailable = LogoutUtils.checkSession(req.getSession());
        if(!isSessionAvailable){
            RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/pages/login.jsp");
            rd.forward(req, resp);
            return;
        }

        List<ProviderService> serviceList = PetServiceRepository.fetchPetServiceList();
        req.setAttribute("serviceAvailable", serviceList);

        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/pages/register-service.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String [] requestAndSpIDs = req.getParameterValues("service");
        UserAccount user = (UserAccount) req.getSession().getAttribute("activeUser");
        Boolean isRequestedRegisered = null;
        for(String id : requestAndSpIDs){
            String[] compound = id.split(":");
            isRequestedRegisered = RequestRepository.insertRequest(Integer.parseInt(compound[0]), user.getAccountId(), Integer.parseInt(compound[1]));
        }

        req.setAttribute("isRequestRegistered", isRequestedRegisered);
        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/pages/register-service.jsp");
        rd.forward(req, resp);
    }
}
