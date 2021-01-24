package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.Id;
import javax.persistence.SecondaryTable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="bloodDonor_camp")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BloodDonorCamp {

	@Id
	private String campName;
	private String campLocation;
}
