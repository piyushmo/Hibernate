package com.example.bean;

import java.util.Date;

public class AccountBean {

	private long accNo;
	private String name;
	private double balance;
	private Date accCreationDate;
	
	public long getAccNo() {
		return accNo;
	}
	public void setAccNo(long accNo) {
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
