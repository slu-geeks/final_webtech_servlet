package com.finalproject.servlets;


import com.finalproject.beans.Feedback;
import com.finalproject.beans.RequestServiceProvider;
import com.finalproject.beans.UserAccount;
import com.finalproject.db.FeedbackRepository;
import com.finalproject.db.RequestRepository;
import com.finalproject.util.LogoutUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by Mehdi on 4/19/17.
 */

@WebServlet(name="give-feedback", urlPatterns = "/give-feedback")
public class GiveFeedback extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean isSessionAvailable = LogoutUtils.checkSession(req.getSession());
        if(!isSessionAvailable){
            resp.sendRedirect("login");
            return;
        }

        UserAccount account = (UserAccount) req.getSession().getAttribute("activeUser");
        List<RequestServiceProvider> requests = RequestRepository.fetchAllUserRequest(account.getAccountId());
        req.setAttribute("allUserRequests", requests);
        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/pages/feedback.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestId = req.getParameter("requestId");
        String feedbackRanking = req.getParameter("feedback_ranking");
        String feedbackMessage = req.getParameter("feedback_message");
        Feedback feedback = new Feedback(Short.parseShort(feedbackRanking),null, feedbackMessage,new Date(), null, (short)1,null, Integer.parseInt(requestId));
        boolean insertSuccessful = FeedbackRepository.insertIntoFeedback(feedback);
        req.setAttribute("insertSuccessful", insertSuccessful);
        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/pages/feedback.jsp");
        rd.forward(req, resp);

    }
}
