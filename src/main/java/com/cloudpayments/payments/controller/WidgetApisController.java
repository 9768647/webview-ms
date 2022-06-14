package com.cloudpayments.payments.controller;

import com.cloudpayments.payments.exception.ControllerException;
import com.cloudpayments.payments.model.Language;
import com.cloudpayments.payments.model.request.CustomerRequest;
import com.cloudpayments.payments.model.request.MozidoTrxRequest;
import com.cloudpayments.payments.bussines.GetWidgetFrontEndCode;
import com.cloudpayments.payments.util.JwtTokenValidator;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import static com.cloudpayments.payments.exception.ErrorResponses.INVALID_SESSION_TOKEN;
import static com.cloudpayments.payments.exception.ErrorResponses.SESSION_EXPIRED;


@RestController

@CrossOrigin
public class WidgetApisController {
    protected final Log logger = LogFactory.getLog(WidgetApisController.class);

    @Autowired
    protected GetWidgetFrontEndCode getWidgetFrontEndCode;

    @Value("${v1.tyk.public.key}")
    private String publicKey;

    @Value("${ribbit.client.id}")
    private String ribbitClientId;

    @Value("${ribbit.client.secret}")
    private String ribbitClientSecret;


    @RequestMapping(value = "/getWidgetData", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Get Widget Data")
    public String getUserLevels(HttpServletRequest request) throws Exception {

        logger.info("Get User Levels -  " + request);

        return getWidgetFrontEndCode.getWidgetCode();
    }

    @RequestMapping(value = "/addbank/widget/get", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Get Widget Data addbank/widget/get")
    public String getWidged(@ApiParam(value = "Tenant name, If you have your tenant use it, if not we provide one.") @RequestHeader(value = "tenantName") String tenantName,
                            @ApiParam(value = "User token provided by auth service, sends Bearer space and token. Ex: Bearer aafefffvwsegf4fswerfg4ggwrg ") @RequestHeader(value = "Authorization") String token,
                            @RequestBody CustomerRequest request) throws Exception {

        logger.info("Get User Levels -  " + request);

        JwtTokenValidator.parseToken(token, publicKey);
        MozidoTrxRequest mozidoTrxRequest = new MozidoTrxRequest(tenantName, token, "");

        return getWidgetFrontEndCode.getWidgetCode(request, ribbitClientId, ribbitClientSecret);
    }


}