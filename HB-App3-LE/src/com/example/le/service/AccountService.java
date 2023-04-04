package com.example.le.service;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.example.le.bean.AccountBean;
import com.example.le.dao.AccountDAO;
import com.example.le.util.SessionUtil;

public class AccountService {

	public static void main(String[] args) {

		AccountDAO dao = new AccountDAO();

		/* Create Table and inserting record */

		/*
		 * AccountBean createAccount = new AccountBean();
		 * 
		 * createAccount.setAccNo(1); createAccount.setName("Suyog");
		 * createAccount.setBalance(99000); createAccount.setAccCreationDate(new
		 * Date()); dao.insertAccountDetails(createAccount);
		 * 
		 * createAccount.setAccNo(2); createAccount.setName("Surya");
		 * createAccount.setBalance(100000); createAccount.setAccCreationDate(new
		 * Date()); dao.insertAccountDetails(createAccount);
		 * 
		 * createAccount.setAccNo(3); createAccount.setName("Ravi");
		 * createAccount.setBalance(96000); createAccount.setAccCreationDate(new
		 * Date()); dao.insertAccountDetails(createAccount);
		 * 
		 * createAccount.setAccNo(4); createAccount.setName("Raja");
		 * createAccount.setBalance(96000); createAccount.setAccCreationDate(new
		 * Date()); dao.insertAccountDetails(createAccount);
		 */

		/* Retrieving account data based on id */
		AccountBean accountBean = dao.getAccoountDetails(1);

		/* Display account details after Retrieving from DAO layer */
		System.out.println("Account Details .. : ");
		System.out.println("Account No .. : " + accountBean.getAccNo());
		System.out.println("Account Holder Name .. : " + accountBean.getName());
		System.out.println("Account Balnce .. : " + accountBean.getBalance());
		System.out.println("Account Creation Date .. : " + accountBean.getAccCreationDate());

		Session session = SessionUtil.getSession();
		session.beginTransaction();
		
		try {
			
			/*org.hibernate.ObjectNotFoundException:*/
			AccountBean accountBeanLoad = (AccountBean) session.load(AccountBean.class, 5L);
			/*java.lang.NullPointerException: Cannot invoke "com.example.le.bean.AccountBean.getAccNo()"*/
			AccountBean accountBeanGet = (AccountBean) session.get(AccountBean.class, 5L);
			System.out.println("Account Details .. : ");
			System.out.println("Account No .. : " + accountBeanGet.getAccNo());
			System.out.println("Account Holder Name .. : " + accountBeanGet.getName());
			System.out.println("Account Balnce .. : " + accountBeanGet.getBalance());
			System.out.println("Account Creation Date .. : " + accountBeanGet.getAccCreationDate());
			
		}catch (HibernateException e) {
			e.printStackTrace();
		}
		
		session.getTransaction().commit();
	}

}
