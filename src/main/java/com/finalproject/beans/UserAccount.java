package com.finalproject.beans;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * Created by s422 on 19/04/2017.
 */
public class UserAccount {

    private Integer accountId;

    @NotNull(message = "username is compulsory!")
    @NotBlank(message = "username is compulsory!")
    @Pattern(regexp = "^[a-z0-9_-]{3,100}$",message = "your username can only be alphabet/numeric/hyphen/underscore!")
    private String username;

    @NotNull(message = "password is compulsory!")
    @NotBlank(message = "password is compulsory!")
    private String password;

    @NotNull(message = "address is compulsory!")
    @NotBlank(message = "address is compulsory!")
    private String address;

    @NotNull(message = "first name is compulsory!")
    @NotBlank(message = "first name is compulsory!")
    @Pattern(regexp = "[a-z-A-Z]*", message = "First name has invalid characters")
    private String firstName;

    @NotNull(message = "last name is compulsory!")
    @NotBlank(message = "last name is compulsory!")
    @Pattern(regexp = "[a-z-A-Z]*", message = "Last name has invalid characters")
    private String lastName;


    private String middleInitial;

    private short status;

    @NotNull(message = "email address is compulsory!")
    @NotBlank(message = "email address is compulsory!")
    @Email(message = "Email Address is not a valid format")
    private String emailAddress;

    @Past(message = "Date of Birth must be the past")
    private Date dateOfBirth;

    private Integer roleId;

    @NotNull(message = "phone number is compulsory!")
    @NotBlank(message = "phone number is compulsory!")
    private String phoneNumber;

    @NotNull(message = "user photo is compulsory!")
    private byte[] userPhoto;

    public UserAccount(String username, String password, String address, String firstName, String lastName, String middleInitial, short status, String emailAddress, Date dateOfBirth, Integer roleId, String phoneNumber, byte[] userPhoto) {
        this.username = username;
        this.password = password;
        this.address = address;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleInitial = middleInitial;
        this.status = status;
        this.emailAddress = emailAddress;
        this.dateOfBirth = dateOfBirth;
        this.roleId = roleId;
        this.phoneNumber = phoneNumber;
        this.userPhoto = userPhoto;
    }

    public UserAccount(Integer accountId, String username, String password, String address, String firstName, String lastName, String middleInitial, short status, String emailAddress, Date dateOfBirth, Integer roleId, String phoneNumber, byte[] userPhoto) {
        this.accountId = accountId;
        this.username = username;
        this.password = password;
        this.address = address;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleInitial = middleInitial;
        this.status = status;
        this.emailAddress = emailAddress;
        this.dateOfBirth = dateOfBirth;
        this.roleId = roleId;
        this.phoneNumber = phoneNumber;
        this.userPhoto = userPhoto;
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

    public String getMiddleName() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public byte[] getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(byte[] userPhoto) {
        this.userPhoto = userPhoto;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }
}
