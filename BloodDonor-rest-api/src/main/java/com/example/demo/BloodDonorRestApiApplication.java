package com.example.demo;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.BloodDonor;
import com.example.demo.entity.BloodDonorCamp;
import com.example.demo.repos.BloodDonorCampRepository;
import com.example.demo.repos.BloodDonorRepository;


@SpringBootApplication
@EnableDiscoveryClient
public class BloodDonorRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BloodDonorRestApiApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner runner() {
		return new CommandLineRunner() {
			@Autowired
			BloodDonorRepository repo;
			@Autowired
			BloodDonorCampRepository camprepo;
			@Override
			public void run(String... args) throws Exception{
				repo.save(new BloodDonor("Arun",22,"male","apos",111112111,"Bangalore",LocalDate.of(1998, Month.OCTOBER, 27),"Unregistered"));
			    camprepo.save(new BloodDonorCamp("Bangalore Blood Camp","Bangalore"));
			}
			
		};
	}
}
