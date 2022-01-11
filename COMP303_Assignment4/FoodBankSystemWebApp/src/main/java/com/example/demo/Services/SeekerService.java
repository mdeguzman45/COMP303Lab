package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.Models.Seeker;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SeekerService {

	@Autowired
	WebClient.Builder builder;

	private final String baseUrl = "http://seeker-service/";
	
	public Flux<Seeker> getAll(){
		Flux<Seeker> seekers = builder.baseUrl(baseUrl)
								.build()
								.get()
								.retrieve()
								.bodyToFlux(Seeker.class);
		
		return seekers;
	}
	
	public Mono<Seeker> getSeekerById(long id) {
		return builder.baseUrl(baseUrl)
				.build()
				.get()
				.uri(String.valueOf(id))
				.retrieve()
				.bodyToMono(Seeker.class);
	}
	
	public Mono<Seeker> addSeeker(Seeker seeker) {
		System.out.println("Call Seeker Add API");
		return builder.baseUrl(baseUrl)
				.build()
				.post()
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.body(Mono.just(seeker), Seeker.class)
				.retrieve()
				.bodyToMono(Seeker.class);
	}
	
	public Mono<Seeker> editSeeker(Seeker seeker) {
		System.out.println("Call Seeker Edit API");
		return builder.baseUrl(baseUrl)
				.build()
				.put()
				.uri(String.valueOf(seeker.getId()))
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.body(Mono.just(seeker), Seeker.class)
				.retrieve()
				.bodyToMono(Seeker.class);
	}
	
	public Mono<Boolean> deleteSeeker(long id) {
		System.out.println("Call Seeker Delete API");
		return builder.baseUrl(baseUrl)
				.build()
				.delete()
				.uri(String.valueOf(id))
				.retrieve()
				.bodyToMono(Boolean.class);
	}
}
