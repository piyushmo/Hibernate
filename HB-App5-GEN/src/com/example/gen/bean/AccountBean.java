package com.example.gen.bean;

import java.util.Date;

public class AccountBean {

	private String accNo;
	private String name;
	private double balance;
	private Date accCreationDate;
	
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Date getAccCreationDate() {
		return accCreationDate;
	}
	public void setAccCreationDate(Date accCreationDate) {
		this.accCreationDate = accCreationDate;
	}
	@Override
	public String toString() {
		return "AccountBean [accNo=" + accNo + ", name=" + name + ", balance=" + balance + ", accCreationDate="
				+ accCreationDate + "]";
	}
	
}
