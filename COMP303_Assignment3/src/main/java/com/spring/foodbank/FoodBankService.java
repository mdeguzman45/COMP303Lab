package com.spring.foodbank;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class FoodBankService {
	Map<Integer, FoodBank> foodbanks = new HashMap<>();

    public void addFoodBank(FoodBank foodBank) throws Exception {
        if(foodbanks.containsKey(foodBank.getFoodBankId())) {
            throw new Exception("This Food Bank Id already exists");
        }
        else {
        	foodbanks.put(foodBank.getFoodBankId(), foodBank);
        }
    }

    public Iterable<FoodBank> getFoodBanks(){
        return foodbanks.values();
    }

    public FoodBank getfoodBank(int foodBankId) throws Exception {

        if(foodbanks.containsKey(foodBankId)) {
            return foodbanks.get(foodBankId);
        }
        else {
            throw new Exception("Food Bank Id not found");
        }
    }

    public void updateFoodBank(FoodBank foodBank) throws Exception {
        if(foodbanks.containsKey(foodBank.getFoodBankId())) {
            foodbanks.put(foodBank.getFoodBankId(), foodBank);
        }
        else {
            throw new Exception("Food Bank Id not found");
        }
    }

    public void deleteFoodBank(int foodBankId) throws Exception {
        if(foodbanks.containsKey(foodBankId)) {
        	foodbanks.remove(foodBankId);
        }
        else {
            throw new Exception("Food Bank Id not found");
        }
    }
}
