package com.example.os.cache.service;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.example.os.cache.bean.AccountBean;
import com.example.os.cache.util.SessionUtil;

public class AccountService {

	public static void main(String[] args) {

		Session session = SessionUtil.getSession();
		session.getTransaction().begin();
		
		AccountBean accountBean = session.get(AccountBean.class, 1L); // first query to database
		System.out.println("Account Details .. : ");
		System.out.println("Account No .. : "+accountBean.getAccountId());
		System.out.println("Account Holder Name .. : "+accountBean.getName());
		System.out.println("Account Balnce .. : "+accountBean.getBalance());
		System.out.println("Account Creation Date .. : "+accountBean.getAccCreationDate());
		
		
		System.out.println("*****************************************************");
		System.out.println("                ");
		
		accountBean = session.get(AccountBean.class, 1L);
		System.out.println("Account Details .. : ");
		System.out.println("Account No .. : "+accountBean.getAccountId());
		System.out.println("Account Holder Name .. : "+accountBean.getName());
		System.out.println("Account Balnce .. : "+accountBean.getBalance());
		System.out.println("Account Creation Date .. : "+accountBean.getAccCreationDate());
		
	}

}
