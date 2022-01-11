package com.spring.foodstock;

public class FoodStock {
	private int foodStockId;
	private String typeOfFood;
	private String quantity;
	private String bestBeforeDate;
	private String status;
	
	public FoodStock(int foodStockId, String typeOfFood, String quantity, String bestBeforeDate, String status) {
		super();
		this.foodStockId = foodStockId;
		this.typeOfFood = typeOfFood;
		this.quantity = quantity;
		this.bestBeforeDate = bestBeforeDate;
		this.status = status;
	}
	public int getFoodStockId() {
		return foodStockId;
	}
	public void setFoodStockId(int foodStockId) {
		this.foodStockId = foodStockId;
	}
	public String getTypeOfFood() {
		return typeOfFood;
	}
	public void setTypeOfFood(String typeOfFood) {
		this.typeOfFood = typeOfFood;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getBestBeforeDate() {
		return bestBeforeDate;
	}
	public void setBestBeforeDate(String bestBeforeDate) {
		this.bestBeforeDate = bestBeforeDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
