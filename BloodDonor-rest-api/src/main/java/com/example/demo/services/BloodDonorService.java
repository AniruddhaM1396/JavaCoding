package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.BloodDonor;
import com.example.demo.entity.BloodDonorCamp;
import com.example.demo.repos.BloodDonorRepository;



@Service
public class BloodDonorService {

	@Autowired	
	private BloodDonorRepository repo;
	
	public List<BloodDonor> findAll(){
		return this.repo.findAll();
	}
	
	public BloodDonor addBloodDonor(BloodDonor entity) {
		return this.repo.save(entity);
	}
	
	public boolean deleteBloodDonor(int id) {
			if(this.repo.existsById(id)==true) {
				this.repo.deleteById(id);
			return true;
			}else {
				return false;
			}
	}
	
	public BloodDonor updateBloodDonor(BloodDonor bloodDonor) {
		
	return this.repo.save(bloodDonor);
	}
	
	public List<BloodDonor> findDonorsByBloodGroup(String donorBloodgroup){
		return this.repo.findBydonorBloodgroup(donorBloodgroup);
	}
	
	public List<BloodDonor> findByEligibilty(){
		return this.repo.findBloodDonorsBylastDonated();
	}
	
	public List<BloodDonor> findByEligibiltyAndBloodgroup(String donorBloodgroup){
		return this.repo.findBylastDonatedAndBloodgroup(donorBloodgroup);
	}
	
	public int updateBloodDonorCamp(int donorPhone, String revisedCost){
		return this.repo.updateBloodDonor(donorPhone, revisedCost);
	}
	
}
