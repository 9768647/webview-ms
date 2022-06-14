package com.cloudpayments.payments.model.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;

/**
 * Created by kendy on 11/10/19.
 */
@ApiModel(description = "Json model required make a call to switch.")
public class MozidoTrxRequest {

    @JsonIgnore
    private String tenantName;

    @JsonIgnore
    private String token;

    @JsonIgnore
    private String playerId;

    @JsonIgnore
    private Boolean valid;

    @JsonIgnore
    private String merchantId;


    public MozidoTrxRequest() { }

    public MozidoTrxRequest(String tenantName, String token, String playerId) {
        this.tenantName = tenantName;
        this.token = token;
        this.playerId = playerId;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }
}
