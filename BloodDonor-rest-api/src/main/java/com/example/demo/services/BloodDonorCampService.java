package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.BloodDonorCamp;
import com.example.demo.repos.BloodDonorCampRepository;

@Service
public class BloodDonorCampService {
	
	@Autowired
	BloodDonorCampRepository camprepo;
	
	public List<BloodDonorCamp> findAll(){
		return this.camprepo.findAll();
	}
	
	public BloodDonorCamp addBloodDonorCamp(BloodDonorCamp bloodDonorCamp) {
		return this.camprepo.save(bloodDonorCamp);
	}
	
	public int deleteBloodDonorCamp(String campName) {
		int result = 0;
		if(this.camprepo.existsById(campName)) {
			result=1;
			this.camprepo.deleteById(campName);
		}
		return result;
	}
	
	public List<BloodDonorCamp> findCampBycampLocation(String camplocation){
		return this.camprepo.findBycampLocation(camplocation);
	}
}
