package com.harsh.ApiGateway.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableHystrix
public class GatewayConfig {

    @Autowired
    private AuthenticationFilter authenticationFilter;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("QUIZ-SERVICE", r-> r.path("/quiz/**")
                        .filters(f->f.filter(authenticationFilter))
                        .uri("lb://QUIZ-SERVICE"))
                .route("QUESTION-SERVICE", r-> r.path("/questions/**")
                        .filters(f->f.filter(authenticationFilter))
                        .uri("lb://QUESTION-SERVICE"))
                .route("JWT-SERVICE", r-> r.path("/auth/**")
                        .filters(f->f.filter(authenticationFilter))
                        .uri("lb://JWT-SERVICE"))
                .build();
    }
}
