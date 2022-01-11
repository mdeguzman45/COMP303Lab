package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.Models.FoodBank;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FoodBankService {

	@Autowired
	WebClient.Builder builder;

	private final String baseUrl = "http://foodbank-service/";
	
	public Flux<FoodBank> getAll(){
		Flux<FoodBank> foodbanks = builder.baseUrl(baseUrl)
								.build()
								.get()
								.retrieve()
								.bodyToFlux(FoodBank.class);
		
		return foodbanks;
	}
	
	public Mono<FoodBank> getFoodBankById(long id) {
		return builder.baseUrl(baseUrl)
				.build()
				.get()
				.uri(String.valueOf(id))
				.retrieve()
				.bodyToMono(FoodBank.class);
	}
	
	public Mono<FoodBank> addFoodBank(FoodBank foodBank) {
		System.out.println("Call FoodBank Add API");
		return builder.baseUrl(baseUrl)
				.build()
				.post()
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.body(Mono.just(foodBank), FoodBank.class)
				.retrieve()
				.bodyToMono(FoodBank.class);
	}
	
	public Mono<FoodBank> editFoodBank(FoodBank foodBank) {
		System.out.println("Call FoodBank Edit API");
		return builder.baseUrl(baseUrl)
				.build()
				.put()
				.uri(String.valueOf(foodBank.getId()))
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.body(Mono.just(foodBank), FoodBank.class)
				.retrieve()
				.bodyToMono(FoodBank.class);
	}
	
	public Mono<Boolean> deleteFoodBank(long id) {
		System.out.println("Call FoodBank Delete API");
		return builder.baseUrl(baseUrl)
				.build()
				.delete()
				.uri(String.valueOf(id))
				.retrieve()
				.bodyToMono(Boolean.class);
	}
}
