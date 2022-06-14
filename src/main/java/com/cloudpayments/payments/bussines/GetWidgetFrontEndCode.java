package com.cloudpayments.payments.bussines;


import com.cloudpayments.payments.exception.ControllerException;
import com.cloudpayments.payments.model.request.CustomerRequest;
import com.cloudpayments.payments.service.impl.HttpServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class GetWidgetFrontEndCode {

    @Autowired
    HttpServiceImpl httpService;

    @Value("${ribbit.url}")
    private String ribbitUrl;


    public String getWidgetCode() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        JSONObject obj = new JSONObject();

        obj.put("clientId", "076eff81-bae2-41a0-afae-19d66ea02168");
        obj.put("clientSecret", "B8/OGqOkB5DPzs8NBzoAhALiLYDoedHB9Vsm1kbja28=");
        obj.put("customerId", "ashwin24");

        String body = "merchant=" + obj.toJSONString();

        ResponseEntity<String> response = httpService.restTemplate().exchange(ribbitUrl, HttpMethod.POST, new HttpEntity<>(body, headers), String.class);
        System.out.println("Return is " + response);

        return response.getBody();
    }

    public String getWidgetCode(CustomerRequest request, String ribbitClientId, String ribbitClientSecret) throws ControllerException {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        request.setClientId(ribbitClientId);
        request.setClientSecret(ribbitClientSecret);

        request.isValid();

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = null;
        try {
            json = ow.writeValueAsString(request);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        String body = "merchant=" + json;
        ResponseEntity<String> response = httpService.restTemplate().exchange(ribbitUrl, HttpMethod.POST, new HttpEntity<>(body, headers), String.class);
        System.out.println("Return is " + response);


        return response.getBody();
    }

}
