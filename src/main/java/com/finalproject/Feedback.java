package com.finalproject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Mehdi on 4/19/17.
 */

@WebServlet("/feedback")
public class Feedback extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String feedbackId = req.getParameter("feedback");
        String feedbackRanking = req.getParameter("feedback_ranking");
        String feedbackMessage = req.getParameter("feedback_message");

        System.out.printf("feedbackId is: %s\nfeedback ranking is: %s\nfeedback message is: %s\n",
                feedbackId, feedbackRanking, feedbackMessage);

    }
}
