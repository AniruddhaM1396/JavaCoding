package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.BloodDonor;
import com.example.demo.entity.BloodDonorCamp;
import com.example.demo.services.BloodDonorService;

@RestController
@RequestMapping(path = "/api/v1/donors")
public class BloodDonorController {
	
	@Autowired
	private BloodDonorService service;
	
	@GetMapping(path = "/")
	public List<BloodDonor> findAll(){
		return this.service.findAll();
	}
	
	@PostMapping(path = "/")
	@ResponseStatus(value = HttpStatus.CREATED)
	
	public BloodDonor addBloodDonor(@RequestBody BloodDonor bloodDonor) {
		
		return this.service.addBloodDonor(bloodDonor);
	}
	
	
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<?> deleteBloodDonor(@PathVariable("id") int id) {
		
		boolean deletedBloodDonor = this.service.deleteBloodDonor(id);
		if(deletedBloodDonor == false) {
			return ResponseEntity.notFound().build();
		}
		else {
			return ResponseEntity.ok().body(deletedBloodDonor);
		}
	}
	
	
	@PostMapping("/update")
	public BloodDonor updateBloodDonor(@RequestBody BloodDonor bloodDonor) {
		return this.service.updateBloodDonor(bloodDonor);
	}

	@GetMapping(path = "/bloodgroup/{donorBloodgroup}")
	public List<BloodDonor> findBydonorBloodgroup(@PathVariable("donorBloodgroup") String donorBloodgroup){
		return this.service.findDonorsByBloodGroup(donorBloodgroup);
	}
	
	@GetMapping(path = "/eligible")
	public List<BloodDonor> findBloodDonorsBylastDonated(){
		return this.service.findByEligibilty();
	}
	
	@GetMapping(path = "/eligiblebloodgroup/{donorBloodgroup}")
	public List<BloodDonor> findBylastDonatedAndBloodgroup(@PathVariable("donorBloodgroup") String donorBloodgroup){
		return this.service.findByEligibiltyAndBloodgroup(donorBloodgroup);
	}
	
	@PutMapping(path ="/bloodDonorCamp/{donorPhone}/{revised}")
	public ResponseEntity<String> updateBloodDonor(@PathVariable("donorPhone") int donorPhone,@PathVariable("revised") String revised){
		int rowsUpdated =this.service.updateBloodDonorCamp(donorPhone, revised);
		String message = rowsUpdated+":=Rows Updated";
		return ResponseEntity.ok().body(message);
}
	
}
