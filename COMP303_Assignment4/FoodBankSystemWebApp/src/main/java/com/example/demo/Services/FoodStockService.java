package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.Models.FoodStock;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FoodStockService {

	@Autowired
	WebClient.Builder builder;

	private final String baseUrl = "http://foodstock-service/";
	
	public Flux<FoodStock> getAll(){
		Flux<FoodStock> foodstocks = builder.baseUrl(baseUrl)
								.build()
								.get()
								.retrieve()
								.bodyToFlux(FoodStock.class);
		
		return foodstocks;
	}
	
	public Mono<FoodStock> getFoodStockById(long id) {
		return builder.baseUrl(baseUrl)
				.build()
				.get()
				.uri(String.valueOf(id))
				.retrieve()
				.bodyToMono(FoodStock.class);
	}
	
	public Mono<FoodStock> addFoodStock(FoodStock foodStock) {
		System.out.println("Call FoodStock Add API");
		return builder.baseUrl(baseUrl)
				.build()
				.post()
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.body(Mono.just(foodStock), FoodStock.class)
				.retrieve()
				.bodyToMono(FoodStock.class);
	}
	
	public Mono<FoodStock> editFoodStock(FoodStock foodStock) {
		System.out.println("Call FoodStock Edit API");
		return builder.baseUrl(baseUrl)
				.build()
				.put()
				.uri(String.valueOf(foodStock.getId()))
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.body(Mono.just(foodStock), FoodStock.class)
				.retrieve()
				.bodyToMono(FoodStock.class);
	}
	
	public Mono<Boolean> deleteFoodStock(long id) {
		System.out.println("Call FoodStock Delete API");
		return builder.baseUrl(baseUrl)
				.build()
				.delete()
				.uri(String.valueOf(id))
				.retrieve()
				.bodyToMono(Boolean.class);
	}
}
