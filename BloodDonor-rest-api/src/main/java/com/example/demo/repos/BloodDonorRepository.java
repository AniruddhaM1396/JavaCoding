package com.example.demo.repos;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.BloodDonor;
import com.example.demo.entity.BloodDonorCamp;



@Repository
public interface BloodDonorRepository extends JpaRepository<BloodDonor, Integer> {
	
	
	List<BloodDonor> findBydonorBloodgroup(String donorBloodgroup);
	
	@Query(value="select * from blood_donor where lastDonated > date(now()-interval 6 month)",nativeQuery = true)
	List<BloodDonor> findBloodDonorsBylastDonated();
	
	@Query(value="select * from blood_donor where lastDonated > date(now()-interval 6 month) and donorBloodgroup=:srchCondition",nativeQuery = true)
	List<BloodDonor> findBylastDonatedAndBloodgroup(@Param("srchCondition") String cost);

	@Query(value="update blood_donor set  bloodCampRegistered=:revised where donorPhone=:id",nativeQuery = true)
	@Modifying
	@Transactional
	int updateBloodDonor(@Param("id") int donorPhone, @Param("revised") String bloodCampRegistered);
	
}
