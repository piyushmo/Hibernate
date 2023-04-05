package com.example.one.to.one.service;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.one.to.one.bean.Account;
import com.example.one.to.one.bean.Employee;
import com.example.one.to.one.util.SessionUtil;


public class CreateRecord {

	public static void main(String[] args) {

		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		
		Account account = new Account();
        account.setAccountNumber("123-345-6548");
        
        Employee emp = new Employee();
        emp.setEmail("sujitsalunke@gmail.com");
        emp.setFirstName("Sujit");
        emp.setLastName("Salunke");
        
        emp.setAccount(account);
        account.setEmployee(emp);
        //Save Employee
        session.save(emp);

        tx.commit();
        SessionUtil.closeSession(session);
		
	}

}
