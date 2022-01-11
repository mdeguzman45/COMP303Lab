package com.spring.jpa;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawPassword = "password";
		
		String encodedPassword = encoder.encode(rawPassword);
		
		System.out.println("Encoded password: " + encodedPassword);

	}

}
