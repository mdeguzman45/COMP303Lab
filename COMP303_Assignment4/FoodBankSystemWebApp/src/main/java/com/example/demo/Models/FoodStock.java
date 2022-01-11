package com.example.demo.Models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodStock {
	private long id;
	private String name;
	private String type;
	private String quantity;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate donationDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate bestBefore;
	private String status;
}
