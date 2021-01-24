package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.Id;
import javax.persistence.SecondaryTable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="blood_donor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BloodDonor {

	
	private String donorName;
	private int donorAge;
	private String donorGender;
	private String donorBloodgroup;
	@Id
	private int donorPhone;
	private String donorLocation;
	private LocalDate lastDonated;
	private String bloodCampRegistered;
	
	
}
