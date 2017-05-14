package com.finalproject.db;

import com.finalproject.beans.Feedback;
import com.finalproject.beans.PetService;
import com.finalproject.beans.Request;
import com.finalproject.beans.RequestServiceFeedback;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by mehdi on 5/14/17.
 */
public class FeedbackRepository {

    public static List<RequestServiceFeedback> fetchAllUserRequestWithFeedback(Integer userId) {
        String query = "SELECT * FROM feedback " +
                "JOIN service_request USING (request_id) " +
                "JOIN pet_service USING (service_id)" +
                "WHERE account_id=?";

        //request
        Integer requestId, serviceId = 0, accountId = 0, serviceProviderId = 0;
        java.util.Date requestDate, startServicing, endServicing;
        Short requestStatus;

        //service
        String serviceName, serviceDescription;
        int petServiceId, servicePrice, serviceHours, spId;
        byte[] servicePicture;

        //feedback
        Integer feedbackId;
        Short ranking, feedbackStatus;
        String phoneNumber, feedbackMessage, checkedDescription;
        Date feedbackDate, considerationDate;
        List<RequestServiceFeedback> requestServiceFeedbacks = new ArrayList<>();

        try {
            PreparedStatement stm = DatabaseConnectivity.getConnection().prepareStatement(query);
            stm.setInt(1, userId);
            ResultSet result = stm.executeQuery();

            if (!result.isBeforeFirst()) {
                return null;
            }

            while (result.next()) {

                requestId = result.getInt("request_id");
                requestDate = result.getDate("request_date");
                startServicing = result.getDate("start_servicing");
                endServicing = result.getDate("end_servicing");
                requestStatus = result.getShort("request_status");
                Request request = new Request(requestId,requestDate, startServicing, endServicing, requestStatus, serviceId, accountId, serviceProviderId);

                petServiceId = result.getInt("service_id");
                serviceName = result.getString("service_name");
                serviceDescription = result.getString("service_description");
                servicePrice = result.getInt("service_price");
                servicePicture = result.getBytes("service_picture");
                serviceHours = result.getInt("service_hours");

                PetService petService = new PetService(petServiceId,
                        serviceName, serviceDescription, servicePrice, servicePicture, serviceHours, 0
                );

                feedbackId = result.getInt("feedback_id");
                ranking = result.getShort("ranking");
                phoneNumber = result.getString("contacting_phone_number");
                feedbackMessage = result.getString("feedback_messages");
                feedbackDate = result.getDate("feedback_date");
                considerationDate = result.getDate("consideration_date");
                feedbackStatus = result.getShort("feedback_status");
                checkedDescription = result.getString("checked_description");
                requestId = result.getInt("request_id");
                Feedback feedback = new Feedback(feedbackId, ranking, phoneNumber, feedbackMessage, feedbackDate, considerationDate, feedbackStatus, checkedDescription, requestId);
                requestServiceFeedbacks.add(new RequestServiceFeedback(request, petService, feedback));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return requestServiceFeedbacks;
    }

    public static boolean insertIntoFeedback(Feedback feedback){
        String sql = "INSERT INTO feedback (" +
                " ranking, contacting_phone_number, feedback_messages, feedback_date, " +
                "consideration_date, feedback_status, checked_description, request_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement pstmt = DatabaseConnectivity.getConnection().prepareStatement(sql);

            pstmt.setShort(1, feedback.getFeedbackRanking());
            pstmt.setString(2, feedback.getFeedbackPhoneNumber());
            pstmt.setString(3, feedback.getFeedbackMessage());
            pstmt.setDate(4, new java.sql.Date(feedback.getFeedbackDate().getTime()));
            pstmt.setNull(5, Types.DATE);
            pstmt.setInt(6, feedback.getFeedbackStatus());
            pstmt.setString(7, null);
            pstmt.setInt(8, feedback.getRequestId());
            pstmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
