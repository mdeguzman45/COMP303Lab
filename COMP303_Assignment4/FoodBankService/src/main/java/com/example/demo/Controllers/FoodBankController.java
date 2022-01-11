package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.FoodBank;
import com.example.demo.Services.FoodBankService;

@RestController
public class FoodBankController {
	@Autowired
	FoodBankService service;
	
	@GetMapping
	public List<FoodBank> getAll() {
		System.out.println("All the Food Banks information");
		return service.getAll();
	}
	
	@GetMapping("{id}")
	public FoodBank getById(@PathVariable("id") final long id) {
		System.out.println("Get Food Bank with Id: " + id);
		return service.getById(id);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<FoodBank> updateById(@PathVariable("id") final long id,
								@RequestBody final FoodBank foodBank){
		System.out.println("Update Food Bank with Id: " + id);
		foodBank.setId(id);
		FoodBank result = service.getById(id);
		// Food Bank does not exist
		if(result == null)
			return ResponseEntity.badRequest().build();
		
		FoodBank updateResult = service.save(foodBank);
		return ResponseEntity.ok(updateResult);
	}
	
	@PostMapping
	public FoodBank add(@RequestBody final FoodBank foodBank){
		System.out.println("Adding Food Bank");
		FoodBank addResult = service.save(foodBank);
		return addResult;
	}
	
	@DeleteMapping("{id}")
	public boolean deleteById(@PathVariable("id") final long id){
		System.out.println("Delete Food Bank with Id: " + id);
		
		try{
			service.removeById(id);
		}catch(Exception ex) {
			return false;
		}
		
		return true;
	}
}
