package com.mezo.athena.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

/**
 * @author liu
 */
@SpringBootApplication
public class AthenaGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(AthenaGatewayApplication.class, args);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes().route("path_route", r -> r.path("/csdn").uri("https://blog.csdn.net")).build();
    }

}
