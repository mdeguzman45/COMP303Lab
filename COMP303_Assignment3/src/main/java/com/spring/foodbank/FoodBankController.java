package com.spring.foodbank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodBankController {
	@Autowired
    FoodBankService foodBankService;
	
//	@ResponseBody
//	@RequestMapping("")
//	public String foodbankHome()
//	{
//		return "Create a Food Bank Web service";
//	}

    @RequestMapping(value = "/foodbank/{foodBankId}", method = RequestMethod.GET)
    FoodBank getFoodBank(@PathVariable("foodBankId") int foodBankId) throws Exception {
        return foodBankService.getfoodBank(foodBankId);
    }

    @RequestMapping(value = "/foodbanks", method = RequestMethod.GET)
    Iterable<FoodBank> getFoodBanks() {
        return foodBankService.getFoodBanks();
    }

    @RequestMapping(value = "/foodbank", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    void addFoodBank(@RequestBody FoodBank foodBank) throws Exception {
    	foodBankService.addFoodBank(foodBank);
    }

    @RequestMapping(value = "/foodbank/{foodBankId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    void updateFoodBank(@PathVariable("foodBankId") int foodBankId, @RequestBody FoodBank foodBank) throws Exception {
    	foodBank.setFoodBankId(foodBankId);
    	foodBankService.updateFoodBank(foodBank);
    }

    @RequestMapping(value = "/foodbank/{foodBankId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    void deleteFoodBank(@PathVariable("foodBankId") int foodBankId) throws Exception {
    	foodBankService.deleteFoodBank(foodBankId);
    }
}
