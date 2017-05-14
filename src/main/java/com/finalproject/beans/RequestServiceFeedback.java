package com.finalproject.beans;

/**
 * Created by mehdi on 5/14/17.
 */
public class RequestServiceFeedback {
    private Request request;
    private PetService petService;
    private Feedback feedback;

    public RequestServiceFeedback(Request request, PetService petService, Feedback feedback) {
        this.request = request;
        this.petService = petService;
        this.feedback = feedback;
    }

    public PetService getPetService() {
        return petService;
    }

    public void setPetService(PetService petService) {
        this.petService = petService;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }
}
