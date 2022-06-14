package com.cloudpayments.payments;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
//
@SpringBootApplication(scanBasePackages = "com.cloudpayments.payments")
//@PropertySource("application.properties")
//@PropertySource("file:/usr/local/apache/tomcat/conf/webview-ms.properties")
public class WebviewServiceApplication {

    protected final static Log logger = LogFactory.getLog(WebviewServiceApplication.class);

    public static void main(String[] args) {
        logger.info("WidgetServiceApplication : main");
        SpringApplication.run(WebviewServiceApplication.class, args);
    }
}
