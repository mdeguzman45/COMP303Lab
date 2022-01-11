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

import com.example.demo.Models.Seeker;
import com.example.demo.Services.SeekerService;

import reactor.core.publisher.Mono;


@RequestMapping("/seekers")
@Controller
public class SeekerController {
	@Autowired
	SeekerService service;
	
	@RequestMapping
	public String getAll(final Model model) {
		
        IReactiveDataDriverContextVariable reactiveData =
                new ReactiveDataDriverContextVariable(service.getAll(), 1);
        
		model.addAttribute("controller", "seeker");
        model.addAttribute("partial", "list");
        model.addAttribute("seekers", reactiveData);
        
		return "index";
	}
	
	@GetMapping("/{id}")
	public String getSeekerById(@PathVariable long id, final Model model) {
		Mono<Seeker> seeker = service.getSeekerById(id);

        model.addAttribute("controller", "seeker");
        model.addAttribute("partial", "detail");
        model.addAttribute("seeker", seeker);
        
		return "index";
	}
	
	@GetMapping("/add")
	public String getSeekerAdd(final Model model) {
        model.addAttribute("controller", "seeker");
        model.addAttribute("partial", "add");
        
		return "index";
	}
	
	@PostMapping("/add")
	public String addSeeker(@ModelAttribute Seeker seeker, final Model model) {
		System.out.println("start post add Seeker -> ");
		try {
			System.out.println("add Seeker -> ");
			Mono<Seeker> result = service.addSeeker(seeker);
			//Evaluate
			result.toFuture().get();
			return "redirect:/seekers";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/seekers/add";
	}
	
	@GetMapping("/edit/{id}")
	public String getSeekerEdit(@PathVariable long id, final Model model) {
		Mono<Seeker> seeker = service.getSeekerById(id);
        model.addAttribute("controller", "seeker");
        model.addAttribute("partial", "edit");
        model.addAttribute("seeker", seeker);
        
		return "index";
	}

	@PostMapping("/edit/{id}")
	public String editSeeker(@ModelAttribute Seeker seeker, final Model model) {
		try {
			Mono<Seeker> result = service.editSeeker(seeker);
			//Evaluate
			result.toFuture().get();
			return "redirect:/seekers/" + String.valueOf(seeker.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		return "redirect:/seekers";
	}
	
	@PostMapping("/delete/{id}")
	public String deleteSeeker(@PathVariable long id) {
		try {
			Mono<Boolean> result = service.deleteSeeker(id);
			//Evaluate
			result.toFuture().get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		return "redirect:/seekers";
	}
}
