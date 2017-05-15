package com.finalproject.servlets;

import com.finalproject.beans.RequestServiceFeedback;
import com.finalproject.beans.RequestServiceProvider;
import com.finalproject.beans.UserAccount;
import com.finalproject.db.FeedbackRepository;
import com.finalproject.db.RequestRepository;
import com.finalproject.util.LogoutUtils;

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
        boolean isSessionAvailable = LogoutUtils.checkSession(req.getSession());
        if(!isSessionAvailable){
            RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/pages/login.jsp");
            rd.forward(req, resp);
            return;
        }

        UserAccount activeUser = (UserAccount) req.getSession().getAttribute("activeUser");
        List<RequestServiceFeedback> feedbackLog = FeedbackRepository.fetchAllUserRequestWithFeedback(activeUser.getAccountId());

             req.setAttribute("requestServiceFeedback", feedbackLog);
        RequestDispatcher reqDispatcher = req.getRequestDispatcher("WEB-INF/pages/feedback-log.jsp");
        reqDispatcher.forward(req, resp);
    }
}
