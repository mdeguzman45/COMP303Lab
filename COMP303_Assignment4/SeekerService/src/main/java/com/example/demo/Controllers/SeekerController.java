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

import com.example.demo.Models.Seeker;
import com.example.demo.Services.SeekerService;

@RestController
public class SeekerController {
	@Autowired
	SeekerService service;
	
	@GetMapping
	public List<Seeker> getAll() {
		System.out.println("All the Food Banks information");
		return service.getAll();
	}
	
	@GetMapping("{id}")
	public Seeker getById(@PathVariable("id") final long id) {
		System.out.println("Get Seeker with Id: " + id);
		return service.getById(id);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Seeker> updateById(@PathVariable("id") final long id,
								@RequestBody final Seeker seeker){
		System.out.println("Update Seeker with Id: " + id);
		seeker.setId(id);
		Seeker result = service.getById(id);
		// Seeker does not exist
		if(result == null)
			return ResponseEntity.badRequest().build();
		
		Seeker updateResult = service.save(seeker);
		return ResponseEntity.ok(updateResult);
	}
	
	@PostMapping
	public Seeker add(@RequestBody final Seeker seeker){
		System.out.println("Adding Seeker");
		Seeker addResult = service.save(seeker);
		return addResult;
	}
	
	@DeleteMapping("{id}")
	public boolean deleteById(@PathVariable("id") final long id){
		System.out.println("Delete Seeker with Id: " + id);
		
		try{
			service.removeById(id);
		}catch(Exception ex) {
			return false;
		}
		
		return true;
	}
}
