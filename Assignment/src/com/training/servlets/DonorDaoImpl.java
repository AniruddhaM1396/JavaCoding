package com.training.servlets;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import com.training.utils.DbConnectionUtil;

public class DonorDaoImpl implements DataAccess<BloodDonor> {
private Connection con;
	
	
	
	public DonorDaoImpl(Connection con) {
		super();
		this.con = con;
	}

	public DonorDaoImpl() {
		super();
		con= DbConnectionUtil.getMySqlConnection();
	}

	@Override
	public int add(BloodDonor t) {

		String ADDSQL="insert into lumen_donor values(?,?,?,?,?,?)";
		int rowsAdded = 0;
		
		try(PreparedStatement pstmt = con.prepareStatement(ADDSQL)) {
			System.out.println("hi");
			pstmt.setString(1, t.getDonorName());
			pstmt.setInt(2, t.getDonorAge());
			pstmt.setString(3, t.getDonorGender());
			pstmt.setString(4, t.getDonorBloodgroup());
			pstmt.setInt(5, t.getDonorPhone());
    		 pstmt.setDate(6, Date.valueOf(t.getDateOfBirth()));
			 
     	 rowsAdded = pstmt.executeUpdate();
			 
		} catch (SQLException e) {

              e.printStackTrace();		}
		
		return rowsAdded;
	}

	@Override
	public List<BloodDonor> findAll() {
	
		
    String sql = "select * from  lumen_donor";
		System.out.println("hi");
         List<BloodDonor>	 donorList = new ArrayList<BloodDonor>();
         
         
		try(PreparedStatement pstmt = con.prepareStatement(sql)) {
			
		 
     	ResultSet rs= pstmt.executeQuery();
		
     	   while(rs.next()) {
     		   
     		 
     		String donorName= rs.getString("donorName");
     		System.out.println("ok");
     		int donorAge = rs.getInt("donorAge");
     		String donorGender= rs.getString("donorGender");
     		String donorBloodgroup= rs.getString("donorBloodgroup");
     		int donorPhone = rs.getInt("donorPhone");
     		LocalDate dateOfBirth = rs.getDate("dateOfBirth").toLocalDate();
     			
     		BloodDonor blooddonor = new BloodDonor(donorName, donorAge, donorGender, donorBloodgroup,donorPhone, dateOfBirth);
     		
     		donorList.add(blooddonor);
     	   }
     	
		} catch (SQLException e) {

              e.printStackTrace();		}
		
		return donorList;

		
	}
}
