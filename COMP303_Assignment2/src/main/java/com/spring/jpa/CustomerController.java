package com.spring.jpa;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerController {
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private ProgramsRepository programsRepository;
	
	@RequestMapping("/")
	public String home()
	{
		return "index";
	}
	
	@RequestMapping("/program")
	public String program(Authentication auth, Model model)
	{
		// get the logged in customer
		Customer customer = getCurrentCustomer(auth);
		String fullName = customer.getFirstName() + " " + customer.getLastName();
		
		System.out.println("Customer fullname: " + fullName);
		System.out.println("Customer userName: " + customer.getUserName());
		
		model.addAttribute("customerName", fullName);
		// get the programs
		model.addAttribute("programs", programsRepository.findAll());
		
		return "program";
	}
	
	// enroll program
	@RequestMapping("/registerprogram")
	public String registerProgram(Authentication auth, Model model,
			@RequestParam(value = "programCode", required = true) long programCode) {
		
		// get the logged in customer
		Customer customer = getCurrentCustomer(auth);
		System.out.println("Enrolling for program: " + programCode);
		Optional<Programs> findProgram = programsRepository.findById(programCode);
		
		if (findProgram.isPresent()) {
			Programs selectedProgram = findProgram.get();
			System.out.println("Program: " + selectedProgram);
			model.addAttribute("program", selectedProgram);
		}
				
		return "registerprogram";	
	}
	
	// update user profile
	@RequestMapping("/updateprofile") 
	public String showUpdateUserForm(@ModelAttribute("customer") Customer customer, Authentication auth, Model model) {
		Customer currentCustomer = getCurrentCustomer(auth);
		model.addAttribute("currentCustomer", currentCustomer);
		
		return "updateprofile";
	}
	
	// get the customer details
	private Customer getCurrentCustomer(Authentication auth) {
		// get the logged in customer
		CustomCustomerDetails customerDetails = (CustomCustomerDetails) auth.getPrincipal();
		Customer authCustomer = customerDetails.getCustomer();
		
		Customer currentCustomer = customerRepository.findByUserName(authCustomer.getUserName());
		
		return currentCustomer;
	}
	
	@RequestMapping("/register")
	public String showRegistrationForm(@ModelAttribute("customer") Customer customer)
	{
		return "registration_form";
	}
	
	@RequestMapping("/merchandise")
	public String showMerch()
	{
		return "merchandise";
	}
	
	@RequestMapping("/addmerchandise")
	public String showAddMerch()
	{
		return "addmerchandise";
	}
	
	@RequestMapping("/removemerchandise")
	public String showRemoveMerch()
	{
		return "removemerchandise";
	}
	
	@PostMapping("/process_register")
	public String processOrder(@ModelAttribute Customer customer) {
		
		System.out.println("FirstName: " + customer.getFirstName());
		System.out.println("lastName: " + customer.getLastName());
		System.out.println("User Name: " + customer.getUserName());
		System.out.println("Password: " + customer.getPassword());
		System.out.println("Address: " + customer.getAddress());
		System.out.println("city: " + customer.getCity());
		System.out.println("Postal Code: " + customer.getPostalCode());
		
		// encode the password
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(customer.getPassword());
		customer.setPassword(encodedPassword);
		
		// todo: handle duplicate username
		customerRepository.save(customer);
		
		return "register_success";
	}

}
