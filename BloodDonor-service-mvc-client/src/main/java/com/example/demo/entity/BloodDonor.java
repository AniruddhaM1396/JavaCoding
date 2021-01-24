package com.example.demo.entity;

import java.time.LocalDate;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BloodDonor {

	
	private String donorName;
	private int donorAge;
	private String donorGender;
	private String donorBloodgroup;
	private int donorPhone;
	private String donorLocation;
	private LocalDate lastDonated;
	private String bloodCampRegistered;
}
