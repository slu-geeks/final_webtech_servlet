package com.finalproject.servlets;

import com.finalproject.beans.Request;
import com.finalproject.beans.RequestServiceProvider;
import com.finalproject.beans.UserAccount;
import com.finalproject.db.RequestRepository;

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

@WebServlet(name="request-log", urlPatterns = "/request-log")
public class RequestLog extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserAccount activeUser = (UserAccount) req.getSession().getAttribute("activeUser");
        List<RequestServiceProvider> allRequests = RequestRepository.fetchAllUserRequest(activeUser.getAccountId());
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
