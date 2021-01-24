package com.example.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.BloodDonorCamp;

@Repository
public interface BloodDonorCampRepository extends JpaRepository<BloodDonorCamp, String> {

	List<BloodDonorCamp> findBycampLocation(String camplocation);
}
