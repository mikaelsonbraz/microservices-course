package com.mikaelsonbraz.apigateway.config;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class ApiGatewayConfig {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder routeLocatorBuilder) {

        Function<PredicateSpec, Buildable<Route>> function =  p -> p.path("/get")
                .filters(f -> f.addRequestHeader("Hello", "World")
                                .addRequestParameter("Hello", "Nordeste"))
                .uri("http://httpbin.org:80");

        return routeLocatorBuilder
                .routes()
                .route(function)
                .build();
    }
}
