package com.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring5.context.webflux.IReactiveDataDriverContextVariable;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;

import com.example.demo.Models.FoodStock;
import com.example.demo.Services.FoodStockService;

import reactor.core.publisher.Mono;


@RequestMapping("/foodstocks")
@Controller
public class FoodStockController {
	@Autowired
	FoodStockService service;
	
	@RequestMapping
	public String getAll(final Model model) {
		
        IReactiveDataDriverContextVariable reactiveData =
                new ReactiveDataDriverContextVariable(service.getAll(), 1);
        
		model.addAttribute("controller", "foodstock");
        model.addAttribute("partial", "list");
        model.addAttribute("foodstocks", reactiveData);
        
		return "index";
	}
	
	@GetMapping("/{id}")
	public String getFoodStockById(@PathVariable long id, final Model model) {
		Mono<FoodStock> foodStock = service.getFoodStockById(id);

        model.addAttribute("controller", "foodstock");
        model.addAttribute("partial", "detail");
        model.addAttribute("foodstock", foodStock);
        
		return "index";
	}
	
	@GetMapping("/add")
	public String getFoodStockAdd(final Model model) {
        model.addAttribute("controller", "foodstock");
        model.addAttribute("partial", "add");
        
		return "index";
	}
	
	@PostMapping("/add")
	public String addFooodStock(@ModelAttribute FoodStock foodStock, final Model model) {
		try {
			Mono<FoodStock> result = service.addFoodStock(foodStock);
			//Evaluate
			result.toFuture().get();
			return "redirect:/foodstocks";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/foodstocks/add";
	}
	
	@GetMapping("/edit/{id}")
	public String getFoodStockEdit(@PathVariable long id, final Model model) {
		Mono<FoodStock> foodStock = service.getFoodStockById(id);
        model.addAttribute("controller", "foodstock");
        model.addAttribute("partial", "edit");
        model.addAttribute("foodstock", foodStock);
        
		return "index";
	}

	@PostMapping("/edit/{id}")
	public String editFoodStock(@ModelAttribute FoodStock foodStock, final Model model) {
		try {
			Mono<FoodStock> result = service.editFoodStock(foodStock);
			//Evaluate
			result.toFuture().get();
			return "redirect:/foodstocks/" + String.valueOf(foodStock.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		return "redirect:/foodstocks";
	}
	
	@PostMapping("/delete/{id}")
	public String deleteFoodStock(@PathVariable long id) {
		try {
			Mono<Boolean> result = service.deleteFoodStock(id);
			//Evaluate
			result.toFuture().get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		return "redirect:/foodstocks";
	}
}
