package com.spring.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomCustomerDetailsService implements UserDetailsService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Customer customer = customerRepository.findByUserName(username);
		if (customer == null) {
			throw new UsernameNotFoundException("User not found");
		}
		
		return new CustomCustomerDetails(customer);
	}

}
