package com.example.criteria.service;

import java.util.Date;

import org.hibernate.Session;

import com.example.bean.criteria.AccountBean;
import com.example.criteria.dao.AccountDAO;
import com.exmple.criteria.util.SessionUtil;

public class AccountService {

	public static void main(String[] args) {

		AccountDAO dao = new AccountDAO();

		/* Create Table and inserting record */

		
		  AccountBean createAccount = new AccountBean();
		  
		  createAccount.setAccountId(1); 
		  createAccount.setName("Suyog");
		  createAccount.setBalance(99000); 
		  createAccount.setAccCreationDate(new  Date()); 
		  dao.insertAccountDetails(createAccount);
		  
		  createAccount.setAccountId(2); 
		  createAccount.setName("Surya");
		  createAccount.setBalance(100000); 
		  createAccount.setAccCreationDate(new Date());
		  dao.insertAccountDetails(createAccount);
		  
		  createAccount.setAccountId(3);
		  createAccount.setName("Ravi");
		  createAccount.setBalance(96000);
		  createAccount.setAccCreationDate(new Date()); 
		  dao.insertAccountDetails(createAccount);
		  
		  createAccount.setAccountId(4); 
		  createAccount.setName("Suyog");
		  createAccount.setBalance(96000);
		  createAccount.setAccCreationDate(new Date()); 
		  dao.insertAccountDetails(createAccount);
		  
		  /*Retrieving account data based on id*/
		  AccountBean accountBean =  dao.getAccoountDetails(1);
		  
		  /*Display account details after Retrieving from DAO layer*/
		  System.out.println("Account Details .. : ");
		  System.out.println("Account No .. : " + accountBean.getAccountId());
		  System.out.println("Account Holder Name .. : " + accountBean.getName());
		  System.out.println("Account Balnce .. : " + accountBean.getBalance());
		  System.out.println("Account Creation Date .. : " +
		  accountBean.getAccCreationDate());
		  
			/* Updating account data based on id */
		  AccountBean updateAccount = new  AccountBean(); 
		  updateAccount.setAccountId(1);
		  updateAccount.setName("Suyog.S.Kulkarni");
		  updateAccount.setBalance(98000);
		  updateAccount.setAccCreationDate(new Date());
		  dao.updateAccountDetails(updateAccount);
		 

		/* Deleting account data based on id */
		// dao.deleteAccountDetails(3);
		
		
	}

}
