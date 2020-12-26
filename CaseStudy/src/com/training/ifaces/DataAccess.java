package com.training.ifaces;

import java.util.List;

public interface DataAccess<T,W> {

	public int add(T t,W w);
    //public int[] addInBatch(T ...t);
	
	public List<T> findAll();
	public int update(T existing, T update);
	public int remove(int mobileNumber);
	public void ListNameCity();
	public List<Object> Birthday(String month);
	public void displayAsc();
	//public T findById(int id);
	
}
