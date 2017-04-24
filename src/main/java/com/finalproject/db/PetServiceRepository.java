package com.finalproject.db;

import com.finalproject.model.PetService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by mehdi on 4/24/17.
 */
public class PetServiceRepository {

    public static List<PetService> fetchPetServiceList(){

        return new ArrayList<PetService>(){{
            add(new PetService(getRandomString(),getRandomString(), 100, 5));
            add(new PetService(getRandomString(),getRandomString(), 100, 5));
            add(new PetService(getRandomString(),getRandomString(), 100, 5));
            add(new PetService(getRandomString(),getRandomString(), 100, 5));
            add(new PetService(getRandomString(),getRandomString(), 100, 5));
        }};
    }


    private static String getRandomString(){
        return UUID.randomUUID().toString().substring(0,5);
    }
}
