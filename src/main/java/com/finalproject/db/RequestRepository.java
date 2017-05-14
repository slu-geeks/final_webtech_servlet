package com.finalproject.db;

import com.finalproject.beans.PetService;
import com.finalproject.beans.Request;
import com.finalproject.beans.RequestServiceProvider;
import com.finalproject.beans.UserAccount;

import java.sql.*;
import java.sql.Date;
import java.util.*;

/**
 * Created by mehdi on 4/25/17.
 */
public class RequestRepository {

    public static boolean insertRequest(Integer serviceId, Integer accountId, Integer spId) {

        try {
            String sql =
                    "INSERT INTO service_request (start_servicing, end_servicing, request_status," +
                            "service_id, account_id, sp_id) VALUES(?, ?, ?, ?, ?, ?);";
            PreparedStatement pstmt = DatabaseConnectivity.getConnection().prepareStatement(sql);
            pstmt.setNull(1, Types.DATE);
            pstmt.setNull(2, Types.DATE);
            pstmt.setInt(3, 1);
            pstmt.setInt(4, serviceId);
            pstmt.setInt(5, accountId);
            pstmt.setInt(6, spId);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static List<RequestServiceProvider> fetchAllUserRequest(Integer userAccountID) {
        String sql = "SELECT distinct * FROM service_request " +
                "JOIN pet_service using(service_id) " +
                "JOIN user_account USING (account_id) " +
                "WHERE service_request.account_id= ? ORDER BY request_status;";

        //request
        Integer requestId, serviceId = 0, accountId = 0, serviceProviderId = 0;
        java.util.Date requestDate, startServicing, endServicing;
        Short requestStatus;

        //for pet service
        String serviceName, serviceDescription;
        int petServiceId = 0, servicePrice, serviceHours, spId = 0;
        byte[] servicePicture;

        //for service provider
        int accountSPId = -1, roleId = -1;
        String username = "", address = "", firstName = "", lastName = "", middleName = "", emailAddress = "", phoneNumber = "";
        short status = -1;
        Date birthday = null;
        byte[] userPhoto = null;

        List<RequestServiceProvider> requestList = new ArrayList<>();
        try {
            PreparedStatement pstmt = DatabaseConnectivity.getConnection().prepareStatement(sql);
            pstmt.setInt(1, userAccountID);
            ResultSet result = pstmt.executeQuery();

            if (!result.isBeforeFirst()) {
                return null;
            }

            while (result.next()) {
                //request
                requestId = result.getInt("request_id");
                requestDate = result.getDate("request_date");
                startServicing = result.getDate("start_servicing");
                endServicing = result.getDate("end_servicing");
                requestStatus = result.getShort("request_status");
//                serviceId = result.getInt("service_request.service_id");
//                accountId = result.getInt("service_request.account_id");
//                serviceProviderId = result.getInt("service_request.sp_id");

                Request request = new Request(requestId,requestDate, startServicing, endServicing, requestStatus, serviceId, accountId, serviceProviderId);

                //pet service
//                petServiceId = result.getInt("pet_service.service_id");
                serviceName = result.getString("service_name");
                serviceDescription = result.getString("service_description");
                servicePrice = result.getInt("service_price");
                servicePicture = result.getBytes("service_picture");
                serviceHours = result.getInt("service_hours");
//                spId = result.getInt("pet_service.sp_id");

                PetService petService = new PetService(petServiceId,
                        serviceName, serviceDescription, servicePrice, servicePicture, serviceHours, spId
                );

                //service provider
                accountSPId = result.getInt("account_id");
                username = result.getString("username");
                address = result.getString("address");
                firstName = result.getString("first_name");
                lastName = result.getString("last_name");
                middleName = result.getString("middle_name");
                status = result.getShort("status");
                emailAddress = result.getString("email_address");
                birthday = result.getDate("birthday");
                phoneNumber = result.getString("phone_number");
                roleId = result.getInt("role_id");
                userPhoto = result.getBytes("user_picture");

                UserAccount serviceProvider = new UserAccount(
                        accountSPId, username, "",
                        address, firstName, lastName, middleName, status, emailAddress,
                        birthday, roleId, phoneNumber, userPhoto);

                requestList.add(new RequestServiceProvider(request, petService, serviceProvider));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return requestList;
    }
}
