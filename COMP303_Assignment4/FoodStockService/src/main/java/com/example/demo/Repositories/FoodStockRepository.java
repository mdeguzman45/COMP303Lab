package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Models.FoodStock;

public interface FoodStockRepository extends JpaRepository<FoodStock, Long>{

}
