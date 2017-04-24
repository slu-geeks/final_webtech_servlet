package com.finalproject.db;

import com.finalproject.model.UserAccount;

import java.sql.Date;
import java.sql.PreparedStatement;

/**
 * Created by mehdi on 4/24/17.
 */
public class UserAccountRepository {
    public static boolean addUserAccount(UserAccount userAccount) {
        try {
            String sql = "INSERT INTO user_account (username, password, address, first_name, last_name, middle_name, status, " +
                    "email_address, birthday, phone_number, role_id, user_picture) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement pstmt = DatabaseConnectivity.getConnection().prepareStatement(sql);
            pstmt.setString(1, userAccount.getUsername());
            pstmt.setString(2,userAccount.getPassword());
            pstmt.setString(3,userAccount.getAddress());
            pstmt.setString(4,userAccount.getFirstName());
            pstmt.setString(5,userAccount.getLastName());
            pstmt.setString(6,userAccount.getMiddleName());
            pstmt.setInt(7, userAccount.getStatus());
            pstmt.setString(8, userAccount.getEmailAddress());
            pstmt.setDate(9, new Date(userAccount.getDateOfBirth().getTime()));
            pstmt.setString(10, userAccount.getPhoneNumber());
            pstmt.setInt(11, userAccount.getRoleId());
            pstmt.setBytes(12, userAccount.getUserPhoto());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
