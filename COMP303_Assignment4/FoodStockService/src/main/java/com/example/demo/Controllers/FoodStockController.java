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

import com.example.demo.Models.FoodStock;
import com.example.demo.Services.FoodStockService;

@RestController
public class FoodStockController {

	@Autowired
	FoodStockService service;
	
	@GetMapping
	public List<FoodStock> getAll() {
		System.out.println("All the Food Stocks information");
		return service.getAll();
	}
	
	@GetMapping("{id}")
	public FoodStock getById(@PathVariable("id") final long id) {
		System.out.println("Get Food Stock with Id: " + id);
		return service.getById(id);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<FoodStock> updateById(@PathVariable("id") final long id,
								@RequestBody final FoodStock foodStock){
		System.out.println("Update Food Stock with Id: " + id);
		foodStock.setId(id);
		FoodStock result = service.getById(id);
		// Food Stock does not exist
		if(result == null)
			return ResponseEntity.badRequest().build();
		
		FoodStock updateResult = service.save(foodStock);
		return ResponseEntity.ok(updateResult);
	}
	
	@PostMapping
	public FoodStock add(@RequestBody final FoodStock foodStock){
		System.out.println("Adding Food Stock");
		FoodStock addResult = service.save(foodStock);
		return addResult;
	}
	
	@DeleteMapping("{id}")
	public boolean deleteById(@PathVariable("id") final long id){
		System.out.println("Delete Food Stock with Id: " + id);
		
		try{
			service.removeById(id);
		}catch(Exception ex) {
			return false;
		}
		
		return true;
	}
}
