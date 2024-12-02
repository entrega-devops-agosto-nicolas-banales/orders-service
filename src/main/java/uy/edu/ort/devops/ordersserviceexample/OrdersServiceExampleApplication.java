package uy.edu.ort.devops.ordersserviceexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import uy.edu.ort.devops.ordersserviceexample.logic.OrdersLogic;

@SpringBootApplication
public class OrdersServiceExampleApplication {

	public static void main(String[] args) {
    String paymentsServiceUrl = "http://payments-service-alb-1611589606.us-east-1.elb.amazonaws.com";
    String shippingServiceUrl = "http://shipping-service-alb-15976227.us-east-1.elb.amazonaws.com";
    String productsServiceUrl = "http://products-service-alb-110946858.us-east-1.elb.amazonaws.com";

    if (args.length > 0) {
        paymentsServiceUrl = args[0];
    }
    if (args.length > 1) {
        shippingServiceUrl = args[1];
    }
    if (args.length > 2) {
        productsServiceUrl = args[2];
    }

    OrdersLogic.setPaymentsServiceUrl(paymentsServiceUrl);
    OrdersLogic.setShippingServiceUrl(shippingServiceUrl);
    OrdersLogic.setProductsServiceUrl(productsServiceUrl);

    SpringApplication.run(OrdersServiceExampleApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

}
