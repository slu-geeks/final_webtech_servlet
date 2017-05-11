package com.finalproject.beans;

/**
 * Created by mehdi on 4/24/17.
 */
public class PetService {
    private Integer serviceId;
    private String serviceName;
    private String serviceDescription;
    private Integer servicePrice;
    private byte[] servicePicture;
    private Integer serviceHours;
    private Integer ServiceProviderId;

    public PetService(Integer serviceId, String serviceName, String serviceDescription, Integer servicePrice, byte[] servicePicture, Integer serviceHours, Integer ServiceProviderId) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.serviceDescription = serviceDescription;
        this.servicePrice = servicePrice;
        this.servicePicture = servicePicture;
        this.serviceHours = serviceHours;
        this.ServiceProviderId = ServiceProviderId;
    }

    public PetService(String serviceName, String serviceDescription, Integer servicePrice, byte[] servicePicture, Integer serviceHours, Integer ServiceProviderId) {
        this.serviceName = serviceName;
        this.serviceDescription = serviceDescription;
        this.servicePrice = servicePrice;
        this.servicePicture = servicePicture;
        this.serviceHours = serviceHours;
        this.ServiceProviderId = ServiceProviderId;
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

    public byte[] getServicePicture() {
        return servicePicture;
    }

    public void setServicePicture(byte[] servicePicture) {
        this.servicePicture = servicePicture;
    }

    public Integer getServiceHours() {
        return serviceHours;
    }

    public void setServiceHours(Integer serviceHours) {
        this.serviceHours = serviceHours;
    }

    public Integer getServiceProviderId() {
        return ServiceProviderId;
    }

    public void setServiceProviderId(Integer serviceProviderId) {
        this.ServiceProviderId = serviceProviderId;
    }
}