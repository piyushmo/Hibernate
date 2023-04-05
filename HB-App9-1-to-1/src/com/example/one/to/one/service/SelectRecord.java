package com.example.one.to.one.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.one.to.one.bean.Account;
import com.example.one.to.one.util.SessionUtil;

public class SelectRecord {

	public static void main(String[] args) {

		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Account account = (Account) session.get(Account.class, 1);
		
		System.out.println("Account Details .. : ");
	
		System.out.println("Account ID .. : "+account.getAccountId());
		System.out.println("Account No .. : "+account.getAccountNumber());
		System.out.println("Account First Name .. : "+account.getEmployee().getFirstName());
		System.out.println("Account Last Name .. : "+account.getEmployee().getLastName());
		System.out.println("Account Email .. : "+account.getEmployee().getEmail());
		
		tx.commit();
		
	}

}
