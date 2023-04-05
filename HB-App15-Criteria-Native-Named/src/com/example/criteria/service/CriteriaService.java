package com.example.criteria.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.criteria.Predicate;

import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.example.bean.criteria.AccountBean;
import com.exmple.criteria.util.SessionUtil;

public class CriteriaService {

	public static List<AccountBean> fecthAllContacts() {
		Session session = SessionUtil.getSession();
		session.getTransaction().begin();

		// create Criteria
		CriteriaQuery<AccountBean> criteriaQuery = session.getCriteriaBuilder().createQuery(AccountBean.class);
		criteriaQuery.from(AccountBean.class);

		List<AccountBean> accounts = session.createQuery(criteriaQuery).getResultList();
		session.close();

		for (AccountBean bean : accounts) {
			System.out.println(bean);
		}

		return accounts;
	}

	public static List<AccountBean> fecthAllWithWhere() {
		Session session = SessionUtil.getSession();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		
		CriteriaQuery<AccountBean> query = builder.createQuery(AccountBean.class);
		
		Root<AccountBean> root = query.from(AccountBean.class);
		
		query.select(root).where(builder.equal(root.get("accountId"), "1"));
		
		List<AccountBean> bankAccountsNameList = session.createQuery(query).getResultList();
		
		for (AccountBean bean : bankAccountsNameList) {
			System.out.println(bean);
		}

		return bankAccountsNameList;

	}

	public static List<AccountBean> fetchWithAndConditions(){
		Session session = SessionUtil.getSession();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		
		CriteriaQuery<AccountBean> query = builder.createQuery(AccountBean.class);
		
		Root<AccountBean> root = query.from(AccountBean.class);	
	
		Predicate predicate = builder.and(
		    builder.equal(root.get("name"), "Suyog"),
		    builder.gt(root.get("balance"), 95000));
	
		query.select(root).where(predicate);
		List<AccountBean> accountBalnce = session.createQuery(query).getResultList();
		
		accountBalnce.stream().collect(Collectors.toList()).forEach(System.out::println);
		
		
		return accountBalnce;
	}
	public static void main(String[] args) {

		CriteriaService.fetchWithAndConditions();
	}

}
