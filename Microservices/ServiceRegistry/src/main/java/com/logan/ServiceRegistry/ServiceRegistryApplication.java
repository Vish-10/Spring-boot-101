package com.logan.ServiceRegistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer //this is to enable the server
public class ServiceRegistryApplication {

	public static void main(String[] args) {

		SpringApplication.run(ServiceRegistryApplication.class, args);
	}

}
