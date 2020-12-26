package com.training.entity;

import java.io.Serializable;

public class Address implements Serializable {
	private int mobileNumber;
	private String contactStreet;
	private String contactCity;
	private String contactState;
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(int mobileNumber, String contactStreet, String contactCity, String contactState) {
		super();
		this.mobileNumber = mobileNumber;
		this.contactStreet = contactStreet;
		this.contactCity = contactCity;
		this.contactState = contactState;
	}
	public int getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getContactStreet() {
		return contactStreet;
	}
	public void setContactStreet(String contactStreet) {
		this.contactStreet = contactStreet;
	}
	public String getContactCity() {
		return contactCity;
	}
	public void setContactCity(String contactCity) {
		this.contactCity = contactCity;
	}
	public String getContactState() {
		return contactState;
	}
	public void setContactState(String contactState) {
		this.contactState = contactState;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contactCity == null) ? 0 : contactCity.hashCode());
		result = prime * result + ((contactState == null) ? 0 : contactState.hashCode());
		result = prime * result + ((contactStreet == null) ? 0 : contactStreet.hashCode());
		result = prime * result + mobileNumber;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (contactCity == null) {
			if (other.contactCity != null)
				return false;
		} else if (!contactCity.equals(other.contactCity))
			return false;
		if (contactState == null) {
			if (other.contactState != null)
				return false;
		} else if (!contactState.equals(other.contactState))
			return false;
		if (contactStreet == null) {
			if (other.contactStreet != null)
				return false;
		} else if (!contactStreet.equals(other.contactStreet))
			return false;
		if (mobileNumber != other.mobileNumber)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return mobileNumber + ","+ contactStreet + "," + contactCity + "," + contactState;
	}
	
}
