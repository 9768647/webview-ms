package com.cloudpayments.payments.model.request;

import java.io.Serializable;

public class CustomerDataRequest implements Serializable {
    public String firstName;
    public String lastName;
    public String emailAddress;
    public String phoneNumber;
    public AddressRequest address;

    public CustomerDataRequest() {
    }

    public CustomerDataRequest(String firstName, String lastName, String emailAddress, String phoneNumber, AddressRequest address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
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

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public AddressRequest getAddress() {
        return address;
    }

    public void setAddress(AddressRequest address) {
        this.address = address;
    }
}