package com.cloudpayments.payments.service.impl;


import com.cloudpayments.payments.service.HttpService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HttpServiceImpl implements HttpService {
    protected final Log logger = LogFactory.getLog(HttpServiceImpl.class);

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Object post(String url, HttpHeaders headers, Object body) {

        HttpEntity request = new HttpEntity(body,headers);
        ResponseEntity response = restTemplate.postForEntity(url,request,Object.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            logger.info("Request Successful.");
            return response.getBody();
        } else {
            logger.error("Request Failed:" + response.toString());
            return response.getStatusCode();
        }
    }

    @Override
    public Object get(String url, HttpHeaders headers) {

        HttpEntity request = new HttpEntity(headers);
        ResponseEntity response = restTemplate.exchange(url,HttpMethod.GET,request,Object.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            logger.info("Request Successful.");
            return response.getBody();
        } else {
            logger.error("Request Failed:" + response.toString());
            return response.getStatusCode();
        }
    }
}
