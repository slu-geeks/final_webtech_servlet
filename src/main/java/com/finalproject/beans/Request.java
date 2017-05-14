package com.finalproject.beans;

import java.util.Date;

/**
 * Created by mehdi on 5/11/17.
 */
public class Request {

        private Integer requestId;
    private Date requestDate;
    private Date startServicing;
    private Date endServicing;
    private Short requestStatus;
    private Integer serviceId;
    private Integer accountId;
    private Integer serviceProviderId;

    public Request(Integer requestId, Date requestDate, Date startServicing, Date endServicing, Short requestStatus, Integer serviceId, Integer accountId, Integer serviceProviderId) {
        this.requestId = requestId;
        this.requestDate = requestDate;
        this.startServicing = startServicing;
        this.endServicing = endServicing;
        this.requestStatus = requestStatus;
        this.serviceId = serviceId;
        this.accountId = accountId;
        this.serviceProviderId = serviceProviderId;
    }

    public Request(Date requestDate,Date startServicing, Date endServicing, Short requestStatus, Integer serviceId, Integer accountId, Integer serviceProviderId) {
        this.requestDate = requestDate;
        this.startServicing = startServicing;
        this.endServicing = endServicing;
        this.requestStatus = requestStatus;
        this.serviceId = serviceId;
        this.accountId = accountId;
        this.serviceProviderId = serviceProviderId;
    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getStartServicing() {
        return startServicing;
    }

    public void setStartServicing(Date startServicing) {
        this.startServicing = startServicing;
    }

    public Date getEndServicing() {
        return endServicing;
    }

    public void setEndServicing(Date endServicing) {
        this.endServicing = endServicing;
    }

    public Short getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(Short requestStatus) {
        this.requestStatus = requestStatus;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getServiceProviderId() {
        return serviceProviderId;
    }

    public void setServiceProviderId(Integer serviceProviderId) {
        this.serviceProviderId = serviceProviderId;
    }
}
