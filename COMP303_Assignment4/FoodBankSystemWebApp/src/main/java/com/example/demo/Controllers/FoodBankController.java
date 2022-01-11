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

import com.example.demo.Models.FoodBank;
import com.example.demo.Services.FoodBankService;

import reactor.core.publisher.Mono;


@RequestMapping("/foodbanks")
@Controller
public class FoodBankController {
	@Autowired
	FoodBankService service;
	
	@RequestMapping
	public String getAll(final Model model) {
		
        IReactiveDataDriverContextVariable reactiveData =
                new ReactiveDataDriverContextVariable(service.getAll(), 1);
        
		model.addAttribute("controller", "foodbank");
        model.addAttribute("partial", "list");
        model.addAttribute("foodbanks", reactiveData);
        
		return "index";
	}
	
	@GetMapping("/{id}")
	public String getFoodBankById(@PathVariable long id, final Model model) {
		Mono<FoodBank> foodBank = service.getFoodBankById(id);

        model.addAttribute("controller", "foodbank");
        model.addAttribute("partial", "detail");
        model.addAttribute("foodbank", foodBank);
        
		return "index";
	}
	
	@GetMapping("/add")
	public String getFoodBankAdd(final Model model) {
        model.addAttribute("controller", "foodbank");
        model.addAttribute("partial", "add");
        
		return "index";
	}
	
	@PostMapping("/add")
	public String addFooodBank(@ModelAttribute FoodBank foodBank, final Model model) {
		try {
			Mono<FoodBank> result = service.addFoodBank(foodBank);
			//Evaluate
			result.toFuture().get();
			return "redirect:/foodbanks";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/foodbanks/add";
	}
	
	@GetMapping("/edit/{id}")
	public String getFoodBankEdit(@PathVariable long id, final Model model) {
		Mono<FoodBank> foodBank = service.getFoodBankById(id);
        model.addAttribute("controller", "foodbank");
        model.addAttribute("partial", "edit");
        model.addAttribute("foodbank", foodBank);
        
		return "index";
	}

	@PostMapping("/edit/{id}")
	public String editFoodBank(@ModelAttribute FoodBank foodBank, final Model model) {
		try {
			Mono<FoodBank> result = service.editFoodBank(foodBank);
			//Evaluate
			result.toFuture().get();
			return "redirect:/foodbanks/" + String.valueOf(foodBank.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		return "redirect:/foodbanks";
	}
	
	@PostMapping("/delete/{id}")
	public String deleteFoodBank(@PathVariable long id) {
		try {
			Mono<Boolean> result = service.deleteFoodBank(id);
			//Evaluate
			result.toFuture().get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		return "redirect:/foodbanks";
	}
}
