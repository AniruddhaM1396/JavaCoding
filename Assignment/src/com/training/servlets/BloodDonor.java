package com.training.servlets;

import java.time.LocalDate;

public class BloodDonor {
	private String donorName;
	private int donorAge;
	private String donorGender;
	private String donorBloodgroup;
	private int donorPhone;
	private LocalDate dateOfBirth;
	public BloodDonor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BloodDonor(String donorName, int donorAge, String donorGender, String donorBloodgroup, int donorPhone,
			LocalDate dateOfBirth) {
		super();
		this.donorName = donorName;
		this.donorAge = donorAge;
		this.donorGender = donorGender;
		this.donorBloodgroup = donorBloodgroup;
		this.donorPhone = donorPhone;
		this.dateOfBirth = dateOfBirth;
	}
	public String getDonorName() {
		return donorName;
	}
	public void setDonorName(String donorName) {
		this.donorName = donorName;
	}
	public int getDonorAge() {
		return donorAge;
	}
	public void setDonorAge(int donorAge) {
		this.donorAge = donorAge;
	}
	public String getDonorGender() {
		return donorGender;
	}
	public void setDonorGender(String donorGender) {
		this.donorGender = donorGender;
	}
	public String getDonorBloodgroup() {
		return donorBloodgroup;
	}
	public void setDonorBloodgroup(String donorBloodgroup) {
		this.donorBloodgroup = donorBloodgroup;
	}
	public int getDonorPhone() {
		return donorPhone;
	}
	public void setDonorPhone(int donorPhone) {
		this.donorPhone = donorPhone;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	@Override
	public String toString() {
		return "BloodDonor [donorName=" + donorName + ", donorAge=" + donorAge + ", donorGender=" + donorGender
				+ ", donorBloodgroup=" + donorBloodgroup + ", donorPhone=" + donorPhone + ", dateOfBirth=" + dateOfBirth
				+ "]";
	}
	
	
}
