package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
@EnableConfigServer
@SpringBootApplication
public class ServiceConfigeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceConfigeApplication.class, args);
	}

}
