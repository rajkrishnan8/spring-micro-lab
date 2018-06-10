package com.tripura.organizations;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class OrganizationsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizationsServiceApplication.class, args);
	}
}