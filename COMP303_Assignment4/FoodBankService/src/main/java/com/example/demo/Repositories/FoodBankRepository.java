package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Models.FoodBank;

public interface FoodBankRepository extends JpaRepository<FoodBank, Long>{

}
