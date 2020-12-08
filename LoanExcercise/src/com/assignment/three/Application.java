package com.assignment.three;

import com.assignment.three.model.Loan;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Loan ramesh= new HousingLoan(100,"Ramesh",98,3);
		double interest1 = ramesh.findRoi();
		System.out.println(interest1);
	}

}
