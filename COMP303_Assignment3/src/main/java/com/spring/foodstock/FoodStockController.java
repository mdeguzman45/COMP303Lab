package com.spring.foodstock;

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
public class FoodStockController {
	@Autowired
    FoodStockService foodStockService;
	
    @RequestMapping(value = "/foodstock/{foodStockId}", method = RequestMethod.GET)
    FoodStock getFoodStock(@PathVariable("foodStockId") int foodStockId) throws Exception {
        return foodStockService.getfoodStock(foodStockId);
    }

    @RequestMapping(value = "/foodstocks", method = RequestMethod.GET)
    Iterable<FoodStock> getFoodStocks() {
        return foodStockService.getFoodStocks();
    }

    @RequestMapping(value = "/foodstock", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    void addFoodStock(@RequestBody FoodStock foodStock) throws Exception {
    	foodStockService.addFoodStock(foodStock);
    }

    @RequestMapping(value = "/foodstock/{foodStockId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    void updateFoodStock(@PathVariable("foodStockId") int foodStockId, @RequestBody FoodStock foodStock) throws Exception {
    	foodStock.setFoodStockId(foodStockId);
    	foodStockService.updateFoodStock(foodStock);
    }

    @RequestMapping(value = "/foodstock/{foodStockId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    void deleteFoodStock(@PathVariable("foodStockId") int foodStockId) throws Exception {
    	foodStockService.deleteFoodStock(foodStockId);
    }
}
