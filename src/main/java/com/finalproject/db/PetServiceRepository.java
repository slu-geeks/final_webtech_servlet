package com.finalproject.db;

import com.finalproject.Feedback;
import com.finalproject.exceptions.UserPasswordException;
import com.finalproject.model.PetService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by mehdi on 4/24/17.
 */
public class PetServiceRepository {
    private Connection connection = DatabaseConnectivity.getConnection();

    public static List<PetService> fetchPetServiceList() {
        final String query = "SELECT * FROM pet_service ORDER BY  service_name;";
        String serviceName, serviceDescription;
        int petServiceId, servicePrice;
        byte[] servicePicture;
        Statement stm;
        List<PetService> allServices = new ArrayList<>();
        try {
            stm = DatabaseConnectivity.getConnection().createStatement();
            ResultSet result = stm.executeQuery(query);

            if (!result.next()) {
                throw new UserPasswordException("The username/password is wrong.");
            }
            while (result.next()) {
                petServiceId = result.getInt("service_id");
                servicePicture = result.getBytes("service_picture");
                serviceName = result.getString("service_name");
                serviceDescription = result.getString("service_description");
                servicePrice = result.getInt("service_price");

                allServices.add(new PetService(petServiceId,
                        serviceName, serviceDescription, servicePrice, null, null, servicePicture
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allServices;

    }


    private static String getRandomString() {
        return UUID.randomUUID().toString().substring(0, 5);
    }
}
