package com.spring.seeker;

public class Seeker {
	private int seekerId;
	private String firstName;
	private String lastName;
	private int age;
	private String gender;
	private String city;
	private String phone;
	
	public Seeker(int seekerId, String firstName, String lastName, int age, String gender, String city, String phone) {
		super();
		this.seekerId = seekerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.city = city;
		this.phone = phone;
	}
	
	public int getSeekerId() {
		return seekerId;
	}
	public void setSeekerId(int seekerId) {
		this.seekerId = seekerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
	
}
