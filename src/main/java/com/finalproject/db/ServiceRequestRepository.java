package com.finalproject.db;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Types;

/**
 * Created by mehdi on 4/25/17.
 */
public class ServiceRequestRepository {

    public static boolean insertRequest(Integer serviceId, Integer accountId){

        try {
            String sql =
                    "INSERT INTO service_request (start_servicing, end_servicing, request_status," +
                            "service_id, account_id) VALUES(?, ?, ?, ?, ?);";
            PreparedStatement pstmt = DatabaseConnectivity.getConnection().prepareStatement(sql);
            pstmt.setNull(1, Types.DATE);
            pstmt.setNull(2,Types.DATE);
            pstmt.setInt(3, 1);
            pstmt.setInt(4,serviceId);
            pstmt.setInt(5,accountId);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
