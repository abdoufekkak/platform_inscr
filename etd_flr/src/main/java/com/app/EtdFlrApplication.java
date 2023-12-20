package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.FeignClient")
public class EtdFlrApplication {

	public static void main(String[] args) {
		SpringApplication.run(EtdFlrApplication.class, args);
	}

}
