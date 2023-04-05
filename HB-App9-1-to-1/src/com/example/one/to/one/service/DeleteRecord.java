package com.example.one.to.one.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.one.to.one.bean.Account;
import com.example.one.to.one.util.SessionUtil;

public class DeleteRecord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Account account = (Account) session.get(Account.class, 1);
		session.delete(account);
		
		tx.commit();
		SessionUtil.closeSession(session);
	}

}
