package com.finalproject.beans;

/**
 * Created by mehdi on 5/11/17.
 */
public class RequestServiceProvider {
    private Request request;
    private PetService petService;
    private UserAccount serviceProvider;

    public RequestServiceProvider(Request request, PetService petService, UserAccount serviceProvider) {
        this.request = request;
        this.petService = petService;
        this.serviceProvider = serviceProvider;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public PetService getPetService() {
        return petService;
    }

    public void setPetService(PetService petService) {
        this.petService = petService;
    }

    public UserAccount getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(UserAccount serviceProvider) {
        this.serviceProvider = serviceProvider;
    }
}
