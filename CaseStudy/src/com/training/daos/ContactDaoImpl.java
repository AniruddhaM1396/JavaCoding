package com.training.daos;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.training.entity.Address;
import com.training.entity.Contact;

import com.training.ifaces.DataAccess;
import com.training.utils.DbConnectionUtil;

public class ContactDaoImpl implements DataAccess<Contact,Address> {
	
	private Connection con;
	
	
	
	public ContactDaoImpl(Connection con) {
		super();
		this.con = con;
	}

	public ContactDaoImpl() {
		super();
		con= DbConnectionUtil.getMySqlConnection();
	}
	@Override
	public int add(Contact t, Address w) {
		int ContactAdded = 0;
		String sql ="insert into lumen_contact values(?,?,?,?,?,?)";
		//String sql2 ="insert into lumen_doctor values(?,?,?,?,?)";
		try(PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			pstmt.setString(1, t.getContactName());
			pstmt.setInt(2, t.getMobileNumber());
			pstmt.setString(3, t.getImageReference());
			pstmt.setDate(4, Date.valueOf(t.getDateOfBirth()));
			pstmt.setString(5, t.getContactEmail());
			pstmt.setString(6, t.getContactGroup());
    		 
			 
     	 ContactAdded = pstmt.executeUpdate();
     	 	 
		} catch (SQLException e) {

              e.printStackTrace();		}
		
		if(ContactAdded == 1) {
			int addressAdded=0;
     		String sql2 ="insert into lumen_address values(?,?,?,?)";
    		try(PreparedStatement pstmt = con.prepareStatement(sql2)) {
    			
    			
    			pstmt.setInt(1, w.getMobileNumber());
    			pstmt.setString(2, w.getContactStreet());
    			pstmt.setString(3, w.getContactCity());
    			pstmt.setString(4, w.getContactState());
    			addressAdded = pstmt.executeUpdate();
     	 }
     	 catch (SQLException e) {

            e.printStackTrace();
     	 }
		}
		return ContactAdded;
	}

	@Override
	public List<Contact> findAll() {
		String sql = "select * from lumen_contact ";
        List<Contact>	 contactList = new ArrayList<Contact>();
		try(PreparedStatement pstmt = con.prepareStatement(sql)) {
    	ResultSet rs= pstmt.executeQuery();
    	   while(rs.next()) { 
    		 
    		String contactName= rs.getString("contactName");
    		int mobileNumber = rs.getInt("mobileNumber");
    		String imageReference = rs.getString("imageReference");
    		LocalDate dateOfBirth = rs.getDate("dateOfBirth").toLocalDate();
    		String contactEmail= rs.getString("contactEmail");
    		String contactGroup= rs.getString("contactGroup");
    		
    		Contact contact = new Contact(contactName, mobileNumber, imageReference, dateOfBirth, contactEmail,contactGroup);
    		
    		contactList.add(contact);
    	   }
    	
		} catch (SQLException e) {

             e.printStackTrace();		}
		
		return contactList;
	}

	@Override
	public int update(Contact existing, Contact update) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int remove(int mobileNumber) {
		// TODO Auto-generated method stub
		String sql="delete from lumen_contact where mobileNumber=?";
		int rowDeleted=0;
		try(PreparedStatement pstmt=con.prepareStatement(sql))
				{
					pstmt.setInt(1, mobileNumber);
					rowDeleted=pstmt.executeUpdate();
				}catch(SQLException e) {
					e.printStackTrace();
				}
		return rowDeleted;
	}

	@Override
	public void ListNameCity() {
		String sql = "select contactName,city from  lumen_address inner join lumen_contact on lumen_address.mobileNumber=lumen_contact.mobileNumber";
		try(PreparedStatement pstmt = con.prepareStatement(sql)) { 
	    	ResultSet rs= pstmt.executeQuery();
			 while(rs.next()) {
				 System.out.println(rs.getString("contactName")+","+rs.getString("city"));
	}
		} catch (SQLException e) {

            e.printStackTrace();	}
	}

	@Override
	public List<Object> Birthday(String month) {
		List<Object> l2=new ArrayList<Object>();
		String sql = " select contactName,dateOfBirth from lumen_contact where monthname(dateOfBirth)=?";
		try(PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			pstmt.setString(1,month);
    	ResultSet rs= pstmt.executeQuery();
		
    	   while(rs.next()) {
    		   System.out.println(rs.getString("contactName")+","+rs.getDate("dateOfBirth").toLocalDate());
    		   l2.add(rs.getString("contactName"));
    		   l2.add(rs.getDate("dateOfBirth").toLocalDate());
    	   }
		
	}catch (SQLException e) {

        e.printStackTrace();	}
		return l2;
	}

	@Override
	public void displayAsc() {
		String sql = " select a.contactName,b.totalcontactGroup from lumen_contact a join(select contactGroup,count(*) as totalcontactGroup from lumen_contact group by contactGroup) b on a.contactGroup=b.contactGroup order by totalcontactGroup;";
		try(PreparedStatement pstmt = con.prepareStatement(sql)) { 
	    	ResultSet rs= pstmt.executeQuery();
			 while(rs.next()) {
				 System.out.println(rs.getString("contactName")+","+rs.getString("totalcontactGroup"));
	}
		} catch (SQLException e) {

            e.printStackTrace();	}
	
		
	}
}


