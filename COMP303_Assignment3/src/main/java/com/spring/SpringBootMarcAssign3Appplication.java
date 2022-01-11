package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringBootMarcAssign3Appplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMarcAssign3Appplication.class, args);
		System.out.println("SpringBootMarcAssign3Appplication REST Web service started...");
	}

}
