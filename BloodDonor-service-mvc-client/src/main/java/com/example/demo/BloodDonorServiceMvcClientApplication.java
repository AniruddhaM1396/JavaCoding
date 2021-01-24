package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.BloodDonor;
import com.example.demo.entity.BloodDonorCamp;


@SpringBootApplication
@EnableDiscoveryClient
public class BloodDonorServiceMvcClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(BloodDonorServiceMvcClientApplication.class, args);
	}

	@Bean
	public RestTemplate template() {
		return new RestTemplate();
	}
	
	@Bean
	public ModelAndView modelAndView() {
		return new ModelAndView();
	}
	
	@Bean 
	public BloodDonor bloodDonor() {
		return new BloodDonor();
	}
	
	@Bean
	public BloodDonorCamp bloodDonorCamp() {
		return new BloodDonorCamp();
	}
}
