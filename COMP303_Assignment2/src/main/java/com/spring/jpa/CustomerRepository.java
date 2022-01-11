package com.spring.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	@Query("SELECT c FROM Customer c WHERE c.userName = ?1")
	public Customer findByUserName(String userName);

}
