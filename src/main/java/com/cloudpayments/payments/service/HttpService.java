package com.cloudpayments.payments.service;

import org.springframework.http.HttpHeaders;

public interface HttpService {
    Object post(String url, HttpHeaders headers, Object body);
    Object get(String url, HttpHeaders headers);
}