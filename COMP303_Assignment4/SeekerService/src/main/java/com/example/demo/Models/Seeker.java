package com.example.demo.Models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Seeker {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private String gender;
	private String city;
	private String phone;
	
	public Seeker(String firstName, String lastName, LocalDate dateOfBirth, String gender, String city, String phone) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.city = city;
		this.phone = phone;
	}
}
