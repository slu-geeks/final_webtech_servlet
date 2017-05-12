package com.finalproject.servlets;

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
import javax.servlet.RequestDispatcher;

/**
 * Created by mehdi on 5/11/17.
 */
@WebServlet(name= "feedback-log" , urlPatterns = "/feedback-log")
public class FeedbackLog extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserAccount activeUser = (UserAccount) req.getSession().getAttribute("activeUser");
        List<RequestServiceProvider> feedBackLog = RequestRepository.fetchAllUserRequest(activeUser.getAccountId());
        req.setAttribute("feedBackLog", feedBackLog);
        RequestDispatcher reqDispatcher = req.getRequestDispatcher("WEB-INF/pages/feedback-log.jsp");
        reqDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
