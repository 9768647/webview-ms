package com.cloudpayments.payments.model.request;

import com.cloudpayments.payments.exception.ControllerException;
import com.cloudpayments.payments.exception.ErrorResponses;
import com.cloudpayments.payments.model.Language;

import java.io.Serializable;

public class CustomerRequest implements Serializable {
    public String clientId;
    public String clientSecret;
    public String customerId;
    public String loanTerms;
    public double fullAmount;
    public double amount;
    public CustomerDataRequest customerData;

    public Boolean isValid() throws ControllerException {
        if (null == this.getCustomerId()) {
            throw new ControllerException(ErrorResponses.CUSTOMER_ID_NOT_SET, Language.ENGLISH);
        }
        return true;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getLoanTerms() {
        return loanTerms;
    }

    public void setLoanTerms(String loanTerms) {
        this.loanTerms = loanTerms;
    }

    public double getFullAmount() {
        return fullAmount;
    }

    public void setFullAmount(double fullAmount) {
        this.fullAmount = fullAmount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public CustomerDataRequest getCustomerData() {
        return customerData;
    }

    public void setCustomerData(CustomerDataRequest customerData) {
        this.customerData = customerData;
    }
}