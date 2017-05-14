package com.finalproject.beans;

import java.util.Date;

/**
 * Created by jerome on 5/12/17.
 */
public class Feedback {
    private Integer feedbackId;
    private Short feedbackRanking;
    private String feedbackPhoneNumber;
    private String feedbackMessage;
    private Date feedbackDate;
    private Date considerationDate;
    private Short feedbackStatus;
    private String checkedDescription;
    private Integer requestId;

    public Feedback(Integer feedbackId, Short feedbackRanking, String feedbackPhoneNumber, String feedbackMessage, Date feedbackDate, Date considerationDate, Short feedbackStatus, String checkedDescription, Integer requestId) {
        this.feedbackId = feedbackId;
        this.feedbackRanking = feedbackRanking;
        this.feedbackPhoneNumber = feedbackPhoneNumber;
        this.feedbackMessage = feedbackMessage;
        this.feedbackDate = feedbackDate;
        this.considerationDate = considerationDate;
        this.feedbackStatus = feedbackStatus;
        this.checkedDescription = checkedDescription;
        this.requestId = requestId;
    }

    public Feedback(Short feedbackRanking, String feedbackPhoneNumber, String feedbackMessage, Date feedbackDate, Date considerationDate, Short feedbackStatus, String checkedDescription, Integer requestId) {
        this.feedbackRanking = feedbackRanking;
        this.feedbackPhoneNumber = feedbackPhoneNumber;
        this.feedbackMessage = feedbackMessage;
        this.feedbackDate = feedbackDate;
        this.considerationDate = considerationDate;
        this.feedbackStatus = feedbackStatus;
        this.checkedDescription = checkedDescription;
        this.requestId = requestId;
    }

    public Integer getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Integer feedbackId) {
        this.feedbackId = feedbackId;
    }

    public Short getFeedbackRanking() {
        return feedbackRanking;
    }

    public void setFeedbackRanking(Short feedbackRanking) {
        this.feedbackRanking = feedbackRanking;
    }

    public String getFeedbackPhoneNumber() {
        return feedbackPhoneNumber;
    }

    public void setFeedbackPhoneNumber(String feedbackPhoneNumber) {
        this.feedbackPhoneNumber = feedbackPhoneNumber;
    }

    public String getFeedbackMessage() {
        return feedbackMessage;
    }

    public void setFeedbackMessage(String feedbackMessage) {
        this.feedbackMessage = feedbackMessage;
    }

    public Date getFeedbackDate() {
        return feedbackDate;
    }

    public void setFeedbackDate(Date feedbackDate) {
        this.feedbackDate = feedbackDate;
    }

    public Date getConsiderationDate() {
        return considerationDate;
    }

    public void setConsiderationDate(Date considerationDate) {
        this.considerationDate = considerationDate;
    }

    public Short getFeedbackStatus() {
        return feedbackStatus;
    }

    public void setFeedbackStatus(Short feedbackStatus) {
        this.feedbackStatus = feedbackStatus;
    }

    public String getCheckedDescription() {
        return checkedDescription;
    }

    public void setCheckedDescription(String checkedDescription) {
        this.checkedDescription = checkedDescription;
    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }
}