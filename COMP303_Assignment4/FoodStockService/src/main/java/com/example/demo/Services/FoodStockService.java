package com.example.demo.Services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Models.FoodStock;
import com.example.demo.Repositories.FoodStockRepository;

@Service
public class FoodStockService {
	@Autowired
	FoodStockRepository repository;
	
	@PostConstruct
	private void initializeSeekers() {
		// Input 3 initial food stock
		if(repository.count() == 0) {
			FoodStock foodStock1 = new FoodStock(
					"Sweet Potatoes",
					"Vegetable",
					"10 Pieces",
					LocalDate.now(),
					LocalDate.of(2021, 10, 28),
					"Available"
				);
			
			FoodStock foodStock2 = new FoodStock(
					"Rice",
					"Grain",
					"50 Kg",
					LocalDate.now(),
					LocalDate.of(2022, 2, 15),
					"Available"
				);
			
			FoodStock foodStock3 = new FoodStock(
					"Cup Noodles",
					"Instant",
					"100 Pieces",
					LocalDate.now(),
					LocalDate.of(2023, 1, 1),
					"Available"
				);
			
			repository.save(foodStock1);
			repository.save(foodStock2);
			repository.save(foodStock3);
		}
	}
	
	public List<FoodStock> getAll(){
		return repository.findAll();
	}
	
	public FoodStock getById(long id){
		Optional<FoodStock> foodStock = repository.findById(id);
		return foodStock.orElse(null);
	}
	
	public FoodStock save(FoodStock foodStock){
		return repository.save(foodStock);
	}
	
	public void removeById(long id) {
		repository.deleteById(id);
	}
}
