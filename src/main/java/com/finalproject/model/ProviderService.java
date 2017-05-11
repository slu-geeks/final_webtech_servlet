package com.finalproject.model;

/**
 * Created by mehdi on 5/11/17.
 */
public class ProviderService {
    private UserAccount serviceProvider;
    private PetService petService;

    public ProviderService(UserAccount serviceProvider, PetService petService) {
        this.petService = petService;
        this.serviceProvider = serviceProvider;
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
