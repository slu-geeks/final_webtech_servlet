package com.finalproject.db;

import com.finalproject.exceptions.NoRoleException;
import com.finalproject.exceptions.UserPasswordException;
import com.finalproject.beans.UserAccount;

import java.sql.*;

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

    public static UserAccount fetchUser(String username, String password) throws UserPasswordException, NoRoleException{
        final String query = String.format("SELECT * FROM user_account where username=  '%s' AND password='%s';", username, password);
        int accountId = -1, roleId = -1;
        String address ="", firstName="", lastName="", middleName="", emailAddress="", phoneNumber="";
        short status = -1;
        Date birthday = null;
        byte[] userPhoto = null;
        Statement stm;
        try {
            stm = DatabaseConnectivity.getConnection().createStatement();
            ResultSet result = stm.executeQuery(query);

            if(!result.isBeforeFirst()){
                throw new UserPasswordException("The username/password is wrong.");
            }


            while (result.next()) {
                accountId = result.getInt("account_id");
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

            }

            if(roleId != 1 && roleId != -1){
                throw new NoRoleException("only customer are allowed to login using this module.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return new UserAccount(
                accountId, username, password,
                address, firstName, lastName,middleName, status, emailAddress,
                birthday, roleId, phoneNumber, userPhoto);
    }
}
