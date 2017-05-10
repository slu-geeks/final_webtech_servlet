package com.finalproject.model;

import java.util.Date;

/**
 * Created by mehdi on 4/24/17.
 */
public class PetService {
    private Integer serviceId;
    private String serviceName;
    private String serviceDescription;
    private Integer servicePrice;
    private Date servicingDurationFrom;
    private Date serviceDurationTo;
    private byte[] servicePicture;
    private Integer sp_id;

    public PetService(Integer serviceId, String serviceName, String serviceDescription, Integer servicePrice, Date servicingDurationFrom, Date serviceDurationTo, byte[] servicePicture, Integer sp_id) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.serviceDescription = serviceDescription;
        this.servicePrice = servicePrice;
        this.servicingDurationFrom = servicingDurationFrom;
        this.serviceDurationTo = serviceDurationTo;
        this.servicePicture = servicePicture;
        this.sp_id = sp_id;
    }

    public PetService(String serviceName, String serviceDescription, Integer servicePrice, Date servicingDurationFrom, Date serviceDurationTo, byte[] servicePicture, Integer sp_id) {
        this.serviceName = serviceName;
        this.serviceDescription = serviceDescription;
        this.servicePrice = servicePrice;
        this.servicingDurationFrom = servicingDurationFrom;
        this.serviceDurationTo = serviceDurationTo;
        this.servicePicture = servicePicture;
        this.sp_id = sp_id;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public Integer getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(Integer servicePrice) {
        this.servicePrice = servicePrice;
    }

    public Date getServicingDurationFrom() {
        return servicingDurationFrom;
    }

    public void setServicingDurationFrom(Date servicingDurationFrom) {
        this.servicingDurationFrom = servicingDurationFrom;
    }

    public Date getServiceDurationTo() {
        return serviceDurationTo;
    }

    public void setServiceDurationTo(Date serviceDurationTo) {
        this.serviceDurationTo = serviceDurationTo;
    }

    public byte[] getServicePicture() {
        return servicePicture;
    }

    public void setServicePicture(byte[] servicePicture) {
        this.servicePicture = servicePicture;
    }

    public Integer getSp_id() {
        return sp_id;
    }

    public void setSp_id(Integer sp_id) {
        this.sp_id = sp_id;
    }
}