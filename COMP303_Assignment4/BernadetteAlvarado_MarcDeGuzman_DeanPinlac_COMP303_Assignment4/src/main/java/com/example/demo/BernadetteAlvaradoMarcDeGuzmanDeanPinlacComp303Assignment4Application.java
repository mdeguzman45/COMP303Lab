package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class BernadetteAlvaradoMarcDeGuzmanDeanPinlacComp303Assignment4Application {

	public static void main(String[] args) {
		SpringApplication.run(BernadetteAlvaradoMarcDeGuzmanDeanPinlacComp303Assignment4Application.class, args);
        System.out.println("Eureka Server started to register a micro-service");
	}

}
