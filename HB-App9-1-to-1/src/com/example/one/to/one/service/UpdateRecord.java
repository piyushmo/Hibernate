package com.example.one.to.one.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.one.to.one.bean.Account;
import com.example.one.to.one.util.SessionUtil;

public class UpdateRecord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		
		Account account = (Account) session.get(Account.class, 1);
		
		account.setAccountNumber("123-345-6549");
		account.getEmployee().setEmail("suyogk87@gmail.com");
		
		tx.commit();
		SessionUtil.closeSession(session);
		
	}

}
