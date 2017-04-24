package com.finalproject.model;

/**
 * Created by mehdi on 4/24/17.
 */
public class PetService {
    private Integer serviceId;
    private String serviceName;
    private String serviceDescription;
    private Integer servicePrice;
    private Integer servicingDuration;

    public PetService(String serviceName, String serviceDescription, Integer servicePrice, Integer servicingDuration) {
        this.serviceName = serviceName;
        this.serviceDescription = serviceDescription;
        this.servicePrice = servicePrice;
        this.servicingDuration = servicingDuration;
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

    public Integer getServicingDuration() {
        return servicingDuration;
    }

    public void setServicingDuration(Integer servicingDuration) {
        this.servicingDuration = servicingDuration;
    }
}
