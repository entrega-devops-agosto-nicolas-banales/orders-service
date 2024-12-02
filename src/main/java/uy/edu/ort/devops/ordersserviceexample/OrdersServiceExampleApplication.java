package uy.edu.ort.devops.ordersserviceexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import uy.edu.ort.devops.ordersserviceexample.logic.OrdersLogic;

@SpringBootApplication
public class OrdersServiceExampleApplication {

	public static void main() {
    String paymentsServiceUrl = "http://payments-service-alb-1611589606.us-east-1.elb.amazonaws.com/payments";
    String shippingServiceUrl = "http://shipping-service-alb-15976227.us-east-1.elb.amazonaws.com/shipping";
    String productsServiceUrl = "http://products-service-alb-110946858.us-east-1.elb.amazonaws.com/products";

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
