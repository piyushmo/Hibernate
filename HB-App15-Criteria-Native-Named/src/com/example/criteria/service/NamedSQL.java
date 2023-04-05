package com.example.criteria.service;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Query;
import org.hibernate.Session;

import com.example.bean.criteria.AccountBean;
import com.exmple.criteria.util.SessionUtil;

public class NamedSQL {

	public static List<AccountBean> accountBeanFindAll(){
		Session session = SessionUtil.getSession();
		
		Query<AccountBean> query = session.createNamedQuery("AccountBean.find.all", AccountBean.class);
		List<AccountBean> accountBeanList = query.getResultList();
		
		accountBeanList.stream().collect(Collectors.toList()).forEach(System.out::println);
		
		session.close();
		
		return accountBeanList;
		
	}
	
	public static List<AccountBean> accountBeanFindById(){
		Session session = SessionUtil.getSession();
		
		Query<AccountBean> query = session.createNamedQuery("AccountBean.find.allID", AccountBean.class);
		query.setParameter("accountId", 1);
		List<AccountBean> accountBeanList = query.getResultList();
		
		accountBeanList.stream().collect(Collectors.toList()).forEach(System.out::println);
		
		session.close();
		
		return accountBeanList;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NamedSQL.accountBeanFindById();
	}

}
