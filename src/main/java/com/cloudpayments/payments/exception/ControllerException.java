package com.cloudpayments.payments.exception;

import com.cloudpayments.payments.model.Language;
import com.cloudpayments.payments.model.response.MozidoCreateMTCresponse;
import com.cloudpayments.payments.model.response.MozidoResponse;
import org.springframework.http.ResponseEntity;

public class ControllerException extends Exception {

    private ErrorResponse errorResponse;

    public ControllerException(ErrorResponses internalServerError) {
    }

    public ControllerException(ErrorResponse errorResponse, Language language) {
        this.errorResponse = errorResponse;
        this.errorResponse.setLanguage(language);
    }

    public ControllerException(String message, ErrorResponse errorResponse) {
        super(message);
        this.errorResponse = new ErrorResponse(errorResponse.getStatus(), errorResponse.getCode(), message);
    }

    public ControllerException(String message, ErrorResponse errorResponse, MozidoResponse mozidoResponse) {
        super(message);
        this.errorResponse = new ErrorResponse(errorResponse.getStatus(), mozidoResponse, errorResponse.getCode(), message);
    }

    public ControllerException(String message, ErrorResponse errorResponse, MozidoResponse mozidoResponse, Boolean tyk) {
        super(message);
        this.errorResponse = new ErrorResponse(errorResponse.getStatus(), mozidoResponse, errorResponse.getCode(), tyk, message);
    }

    public ControllerException(String message, ErrorResponse errorResponse, MozidoCreateMTCresponse mozidoResponse) {
        super(message);
        this.errorResponse = new ErrorResponse(errorResponse.getStatus(), mozidoResponse, errorResponse.getCode(), message);
    }


    public ControllerException(String message, Throwable cause,
                               ErrorResponse errorResponse) {
        super(message, cause);
        this.errorResponse = errorResponse;
    }

    public ControllerException(ResponseEntity response) {
        switch (response.getStatusCode()) {
            default:
                this.errorResponse = ErrorResponses.INTERNAL_SERVER_ERROR;
                break;
        }
    }

    /* Don't know what this method is for, but it's part of the Java API */
    protected ControllerException(String message, Throwable cause,
                                  boolean enableSuppression, boolean writableStackTrace,
                                  ErrorResponse errorResponse) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorResponse = errorResponse;
    }

    public ControllerException(Throwable cause, ErrorResponse errorResponse) {
        super(cause);
        this.errorResponse = errorResponse;
    }

    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }

    public void setErrorResponse(ErrorResponse errorResponse) {
        this.errorResponse = errorResponse;
    }
}
