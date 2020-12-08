package com.excercise.services;
import com.excercise.three.Billable;
public class BillService {
	public void print(Billable bill) {
		System.out.println(bill.calculateSalary());
	}
}
