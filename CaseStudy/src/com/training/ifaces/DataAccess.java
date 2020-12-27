package com.training.ifaces;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import com.training.entity.Contact;

public interface DataAccess<T,W> {

	public int add(T t,W w);
	public List<T> findAll();
	public int update(T existingCon, T updateCon , W existingAdd , W updateAdd);
	public int remove(int mobileNumber);
	public void ListNameCity();
	public List<Object> Birthday(String month);
	public void displayAsc();
	public List<Object> findByGroup(String group);
	
}
