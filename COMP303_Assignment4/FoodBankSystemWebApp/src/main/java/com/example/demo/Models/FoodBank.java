package com.example.demo.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodBank{
	// unique
	private long id;
	private String name;
	private String address;
	private String city;
	private String phone;
	private String website;
	private String email;
}
