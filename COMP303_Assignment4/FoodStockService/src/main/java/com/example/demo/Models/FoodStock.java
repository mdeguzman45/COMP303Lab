package com.example.demo.Models;

import java.time.LocalDate;

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
public class FoodStock {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String name;
	private String type;
	private String quantity;
	private LocalDate donationDate;
	private LocalDate bestBefore;
	private String status;
	
	public FoodStock(String name, String type, String quantity, LocalDate donationDate, LocalDate bestBefore, String status) {
		this.name = name;
		this.type = type;
		this.quantity = quantity;
		this.donationDate = donationDate;
		this.bestBefore = bestBefore;
		this.status = status;
	}
}
