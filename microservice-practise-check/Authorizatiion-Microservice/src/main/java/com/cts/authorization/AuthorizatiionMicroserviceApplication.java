package com.cts.authorization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AuthorizatiionMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthorizatiionMicroserviceApplication.class, args);
	}

}
