package com.assignment.three.model;

public class Loan {
	private double loanAmount;
	private String custName;
	private double cibilScore;
	private double loanPeriod;
	public Loan() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Loan(double loanAmount, String custName, double cibilScore, double loanPeriod) {
		super();
		this.loanAmount = loanAmount;
		this.custName = custName;
		this.cibilScore = cibilScore;
		this.loanPeriod = loanPeriod;
	}
	
	

	public double getLoanAmount() {
		return loanAmount;
	}


	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}


	public String getCustName() {
		return custName;
	}


	public void setCustName(String custName) {
		this.custName = custName;
	}


	public double getCibilScore() {
		return cibilScore;
	}


	public void setCibilScore(double cibilScore) {
		this.cibilScore = cibilScore;
	}


	public double getLoanPeriod() {
		return loanPeriod;
	}


	public void setLoanPeriod(double loanPeriod) {
		this.loanPeriod = loanPeriod;
	}


	public double findRoi(){
		double Interest;
		if(this.cibilScore > 500) {
			Interest = 7.5;
		}else {
			Interest = 8.2;
		}
		return Interest;
	}
	
}
