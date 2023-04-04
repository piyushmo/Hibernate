package com.example.service;

import java.util.Date;

import com.example.bean.AccountBean;
import com.example.dao.AccountDAO;

public class AccountService {
	
	public static void main(String[] args) {
		
		AccountDAO dao = new AccountDAO();
		
		/*Create Table and inserting record*/
		AccountBean createAccount = new AccountBean();
		
		createAccount.setAccNo(3); 
		createAccount.setName("Raja");
		createAccount.setBalance(94000); 
		createAccount.setAccCreationDate(new Date()); 
		dao.insertAccountDetails(createAccount);
		 
		
		createAccount.setAccNo(4);
		createAccount.setName("Surya");
		createAccount.setBalance(100000);
		createAccount.setAccCreationDate(new Date());
		dao.insertAccountDetails(createAccount);
		
		/*Retrieving account data based on id*/
		AccountBean accountBean = dao.getAccoountDetails(1);
		
		/* Display account details after Retrieving from DAO layer */
		System.out.println("Account Details .. : ");
		System.out.println("Account No .. : "+accountBean.getAccNo());
		System.out.println("Account Holder Name .. : "+accountBean.getName());
		System.out.println("Account Balnce .. : "+accountBean.getBalance());
		System.out.println("Account Creation Date .. : "+accountBean.getAccCreationDate());
		
		
		/*Updating  account data based on id*/
		AccountBean updateAccount = new AccountBean();
		updateAccount.setAccNo(1);
		updateAccount.setName("Suyog.S.Kulkarni");
		updateAccount.setBalance(97000);
		updateAccount.setAccCreationDate(new Date());
		dao.updateAccountDetails(updateAccount);
		
		/*Deleting  account data based on id*/
		dao.deleteAccountDetails(3);
		
	}

}
