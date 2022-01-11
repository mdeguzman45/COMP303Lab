package com.spring.foodbank;

public class FoodBank {
	private int foodBankId;
	private String foodBankName;
	private String address;
	private String city;
	private String phone;
	private String website;
	private String email;
	
	public FoodBank(int foodBankId, String foodBankName, String address, String city, String phone, String website,
			String email) {
		super();
		this.foodBankId = foodBankId;
		this.foodBankName = foodBankName;
		this.address = address;
		this.city = city;
		this.phone = phone;
		this.website = website;
		this.email = email;
	}
	public int getFoodBankId() {
		return foodBankId;
	}
	public void setFoodBankId(int foodBankId) {
		this.foodBankId = foodBankId;
	}
	public String getFoodBankName() {
		return foodBankName;
	}
	public void setFoodBankName(String foodBankName) {
		this.foodBankName = foodBankName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
