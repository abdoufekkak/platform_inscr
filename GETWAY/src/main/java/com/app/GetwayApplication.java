package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
@SpringBootApplication
public class GetwayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GetwayApplication.class, args);
	}
	
//	@Bean
//	RouteLocator  customRouteLocator(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route("/todos/**", r -> r
//                    .path("/todos/**")
//                    .filters(f -> f
//                            .setRequestHeader("Custom-Header", "custom-value").rewritePath("/todos/(?<segment>.*)", "/todos/${segment}")
//                            )
//                    .uri("https://jsonplaceholder.typicode.com/")
//                   
//                )
//                .build();
//        }
	@Bean
	DiscoveryClientRouteDefinitionLocator  discoveryClientRouteDefinitionLocator(ReactiveDiscoveryClient rdc,DiscoveryLocatorProperties dlp) {
		return new DiscoveryClientRouteDefinitionLocator(rdc,dlp);
	
	}

}
