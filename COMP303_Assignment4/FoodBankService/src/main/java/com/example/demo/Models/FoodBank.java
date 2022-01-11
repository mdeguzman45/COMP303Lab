package com.example.demo.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class FoodBank{
	// unique
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String name;
	private String address;
	private String city;
	private String phone;
	private String website;
	private String email;
	
	public FoodBank(String name, String address, String city, String phone, String website, String email) {
		this.name = name;
		this.address = address;
		this.city = city;
		this.phone = phone;
		this.website = website;
		this.email = email;
	}
}
