package com.example.gateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class SpringCloudConfiguration {
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("orderModule", r -> r.path("/orderService/**")
                        .uri("lb://order-service")
                )

                .route("paymentModule", r -> r.path("/paymentService/**")
                        .uri("lb://payment-service")
                )
                .build();
    }
}