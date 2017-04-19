package com.finalproject.model;

import java.util.Date;

/**
 * Created by s422 on 19/04/2017.
 */
public class UserAccount {

    private Integer accountId;
    private String username;
    private String password;
    private String address;
    private String firstName;
    private String lastName;
    private String middleIntitial;
    private short status;
    private String emailAddress;
    private Date dateOfBirth;
    private Integer roleId;

    public UserAccount(Integer accountId, String username, String password, String address, String firstName, String lastName, String middleIntitial, short status, String emailAddress, Date dateOfBirth, Integer roleId) {
        this.accountId = accountId;
        this.username = username;
        this.password = password;
        this.address = address;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleIntitial = middleIntitial;
        this.status = status;
        this.emailAddress = emailAddress;
        this.dateOfBirth = dateOfBirth;
        this.roleId = roleId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleIntitial() {
        return middleIntitial;
    }

    public void setMiddleIntitial(String middleIntitial) {
        this.middleIntitial = middleIntitial;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
