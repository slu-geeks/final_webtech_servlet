package com.finalproject.beans;

/**
 * Created by jerome on 5/12/17.
 */
public class Feedback {
    private Integer feedbackId;
    private Integer feedbackRanking;
    private String feedbackMessage;
    
    public Feedback(Integer feedbackId, Integer feedbackRanking, String feedbackMessage){
        this.feedbackId = feedbackId;
        this.feedbackRanking = feedbackRanking;
        this.feedbackMessage = feedbackMessage;
        
    }
    public Feedback(Integer feedbackRanking, String feedbackMessage) {
        this.feedbackRanking = feedbackRanking;
        this.feedbackMessage = feedbackMessage;

    }
    public Integer getFeedbackId() {
        return feedbackId;
    }   
    public void setFeedbackId(Integer feedbackId) {
        this.feedbackId = feedbackId;
    }
    
    public Integer getfFedbackRanking() {
        return feedbackRanking;
    }

    public void setFeedbackRanking(Integer feedbackRanking) {
        this.feedbackRanking = feedbackRanking;
    }
    
    public String getFeedbackMessage() {
        return feedbackMessage;
    }

    public void setFeedbackMessage(String feedbackMessage) {
        this.feedbackMessage = feedbackMessage;
    }

}
