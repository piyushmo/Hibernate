package com.example.criteria.service;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.example.bean.criteria.AccountBean;
import com.exmple.criteria.util.SessionUtil;

public class NativeSQL {

	
	public static List<AccountBean> fetchWithAndConditions(){
		Session session = SessionUtil.getSession();
		
		String query = "SELECT * FROM ACCOUNT_DETAILS WHERE balance > 98000";
		
		List<AccountBean> accounts = session.createNativeQuery(query, AccountBean.class).getResultList();
		
		accounts.stream().collect(Collectors.toList()).forEach(System.out::println);
		
		return accounts;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NativeSQL.fetchWithAndConditions();
	}

}
