package com.sam.antass.authorization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AntassAuthorizationApplication {
	public static void main(String[] args) {
		SpringApplication.run(AntassAuthorizationApplication.class, args);
	}
}
