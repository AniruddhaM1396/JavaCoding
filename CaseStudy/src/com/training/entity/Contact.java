package com.training.entity;

import java.io.Serializable;
import java.time.LocalDate;

public class Contact implements Serializable {
	private String contactName;
	private int mobileNumber;
	private String imageReference;
	private LocalDate dateOfBirth;
	private String contactEmail;
	private String contactGroup;
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Contact(String contactName, int mobileNumber, String imageReference, LocalDate dateOfBirth,
			String contactEmail, String contactGroup) {
		super();
		this.contactName = contactName;
		this.mobileNumber = mobileNumber;
		this.imageReference = imageReference;
		this.dateOfBirth = dateOfBirth;
		this.contactEmail = contactEmail;
		this.contactGroup = contactGroup;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public int getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getImageReference() {
		return imageReference;
	}
	public void setImageReference(String imageReference) {
		this.imageReference = imageReference;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	public String getContactGroup() {
		return contactGroup;
	}
	public void setContactGroup(String contactGroup) {
		this.contactGroup = contactGroup;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contactEmail == null) ? 0 : contactEmail.hashCode());
		result = prime * result + ((contactGroup == null) ? 0 : contactGroup.hashCode());
		result = prime * result + ((contactName == null) ? 0 : contactName.hashCode());
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((imageReference == null) ? 0 : imageReference.hashCode());
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
		Contact other = (Contact) obj;
		if (contactEmail == null) {
			if (other.contactEmail != null)
				return false;
		} else if (!contactEmail.equals(other.contactEmail))
			return false;
		if (contactGroup == null) {
			if (other.contactGroup != null)
				return false;
		} else if (!contactGroup.equals(other.contactGroup))
			return false;
		if (contactName == null) {
			if (other.contactName != null)
				return false;
		} else if (!contactName.equals(other.contactName))
			return false;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (imageReference == null) {
			if (other.imageReference != null)
				return false;
		} else if (!imageReference.equals(other.imageReference))
			return false;
		if (mobileNumber != other.mobileNumber)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return contactName + ","+ mobileNumber + ","+ imageReference + "," + dateOfBirth + "," + contactEmail + ","+ contactGroup ;
	}
	
	
}
