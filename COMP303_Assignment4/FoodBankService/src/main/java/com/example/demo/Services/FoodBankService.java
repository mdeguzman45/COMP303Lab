package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Models.FoodBank;
import com.example.demo.Repositories.FoodBankRepository;

@Service
public class FoodBankService {
	
	@Autowired
	FoodBankRepository repository;
	
	@PostConstruct
	private void initializeFoodBanks() {
		// Initialize FoodBank Rows if empty
		if(repository.count() == 0) {
			// Input 3 initial food banks
			FoodBank foodBank1 = new FoodBank(
						"FoodBank 1",
						"140 Ling Road",
						"Scarborough",
						"1112223333",
						"www.foodbank1.com",
						"foodbank1@gmail.com"
					);
			
			FoodBank foodBank2 = new FoodBank(
					"FoodBank 2",
					"123 Morningside",
					"Scarborough",
					"1112223333",
					"www.foodbank2.com",
					"foodbank2@gmail.com"
				);
			
			FoodBank foodBank3 = new FoodBank(
					"FoodBank 3",
					"43 Lawrence",
					"Scarborough",
					"1113332222",
					"www.foodbank3.com",
					"foodbank3@gmail.com"
				);
			
			repository.save(foodBank1);
			repository.save(foodBank2);
			repository.save(foodBank3);
		}
	}
	
	public List<FoodBank> getAll(){
		return repository.findAll();
	}
	
	public FoodBank getById(long id){
		Optional<FoodBank> foodBank = repository.findById(id);
		return foodBank.orElse(null);
	}
	
	public FoodBank save(FoodBank foodBank){
		return repository.save(foodBank);
	}
	
	public void removeById(long id) {
		repository.deleteById(id);
	}
}
