package com.assignment.three;

import com.assignment.three.model.Loan;

public class HousingLoan extends Loan {

	

	public HousingLoan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HousingLoan(double loanAmount, String custName, double cibilScore, double loanPeriod) {
		super(loanAmount, custName, cibilScore, loanPeriod);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double findRoi() {
		// TODO Auto-generated method stub
		double interestRate = 0.0;
		double interestAmount = 0.0;
		interestRate= super.findRoi();
		interestAmount = (getLoanAmount() * interestRate * getLoanPeriod())/100;
		return interestAmount;
	}
	
		
}
