package com.example.os.cache.bean;

import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Cacheable
@Entity
@Table(name = "ACCOUNT_DETAILS")
public class AccountBean {

	private int accountId;
	private String name;
	private double balance;
	private Date accCreationDate;
	
	@Id
	@Column(name = "acc_no", nullable = true, length = 5)
	                                                
	public int getAccountId() {                    
		return accountId;                              
	}                                               
	public void setAccountId(int accountId) {      
		this.accountId = accountId;                    
	}                                               
	@Column(name = "NAME", nullable = false, length = 20)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "BALANCE", nullable = false, precision = 8, scale = 2)
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	@Column(name = "ACC_CRE_DT", nullable = false)
	public Date getAccCreationDate() {
		return accCreationDate;
	}
	public void setAccCreationDate(Date accCreationDate) {
		this.accCreationDate = accCreationDate;
	}
	@Override
	public String toString() {
		return "AccountBean [accNo=" + accountId + ", name=" + name + ", balance=" + balance + ", accCreationDate="
				+ accCreationDate + "]";
	}
	
}
