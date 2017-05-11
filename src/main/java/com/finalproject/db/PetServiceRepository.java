package com.finalproject.db;

import com.finalproject.exceptions.UserPasswordException;
import com.finalproject.beans.PetService;
import com.finalproject.beans.ProviderService;
import com.finalproject.beans.UserAccount;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by mehdi on 4/24/17.
 */
public class PetServiceRepository {
    private Connection connection = DatabaseConnectivity.getConnection();

    public static List<ProviderService> fetchPetServiceList() {
        final String query = "SELECT * FROM pet_service JOIN user_account on sp_id = account_id ORDER BY service_name;";
        //for pet service
        String serviceName, serviceDescription;
        int petServiceId, servicePrice, serviceHours, spId;
        byte[] servicePicture;

        //for service provider
        int accountId = -1, roleId = -1;
        String username = "", address ="", firstName="", lastName="", middleName="", emailAddress="", phoneNumber="";
        short status = -1;
        Date birthday = null;
        byte[] userPhoto = null;

        Statement stm;

        List<ProviderService> providerServices = new ArrayList<>();

        try {
            stm = DatabaseConnectivity.getConnection().createStatement();
            ResultSet result = stm.executeQuery(query);

            if (!result.next()) {
                throw new UserPasswordException("The username/password is wrong.");
            }
            while (result.next()) {
                petServiceId = result.getInt("service_id");
                serviceName = result.getString("service_name");
                serviceDescription = result.getString("service_description");
                servicePrice = result.getInt("service_price");
                servicePicture = result.getBytes("service_picture");
                serviceHours = result.getInt("service_hours");
                spId = result.getInt("sp_id");

                PetService petService = new PetService(petServiceId,
                        serviceName, serviceDescription, servicePrice, servicePicture, serviceHours, spId
                );

                accountId = result.getInt("account_id");
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
                        accountId, username, "",
                        address, firstName, lastName,middleName, status, emailAddress,
                        birthday, roleId, phoneNumber, userPhoto);

                providerServices.add(new ProviderService(serviceProvider, petService));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return providerServices;

    }


    private static String getRandomString() {
        return UUID.randomUUID().toString().substring(0, 5);
    }
}
