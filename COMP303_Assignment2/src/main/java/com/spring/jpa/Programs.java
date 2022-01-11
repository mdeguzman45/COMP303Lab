package com.spring.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "programs")
public class Programs {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long programcode;
	
	@Column(name="programname")
	private String programName;
	
	@Column(name="duration")
	private String duration;
	
	@Column(name="fee")
	private double fee;
	
	public Programs() {
		
	}
	
	public Programs(Long programcode, String programName, String duration, double fee) {
		super();
		this.programcode = programcode;
		this.programName = programName;
		this.duration = duration;
		this.fee = fee;
	}

	public Long getProgramcode() {
		return programcode;
	}

	public void setProgramcode(Long programcode) {
		this.programcode = programcode;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}
	
	public String toString() {
		String programInfo = "Program Code: " + programcode + "\nProgram Name: " + programName + "\nDuration: " + duration + "\nFee: " + fee + "\n";
		return programInfo;
	}
}
