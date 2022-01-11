package com.spring.foodstock;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class FoodStockService {
	Map<Integer, FoodStock> foodstocks = new HashMap<>();

    public void addFoodStock(FoodStock foodStock) throws Exception {
        if(foodstocks.containsKey(foodStock.getFoodStockId())) {
            throw new Exception("This Food Stock Id already exists");
        }
        else {
        	foodstocks.put(foodStock.getFoodStockId(), foodStock);
        }
    }

    public Iterable<FoodStock> getFoodStocks(){
        return foodstocks.values();
    }

    public FoodStock getfoodStock(int foodStockId) throws Exception {

        if(foodstocks.containsKey(foodStockId)) {
            return foodstocks.get(foodStockId);
        }
        else {
            throw new Exception("Food Stock Id not found");
        }
    }

    public void updateFoodStock(FoodStock foodStock) throws Exception {
        if(foodstocks.containsKey(foodStock.getFoodStockId())) {
        	foodstocks.put(foodStock.getFoodStockId(), foodStock);
        }
        else {
            throw new Exception("Food Stock Id not found");
        }
    }

    public void deleteFoodStock(int foodStockId) throws Exception {
        if(foodstocks.containsKey(foodStockId)) {
        	foodstocks.remove(foodStockId);
        }
        else {
            throw new Exception("Food Stock Id not found");
        }
    }
}
