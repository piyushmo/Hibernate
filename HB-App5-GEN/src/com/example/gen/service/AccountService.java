package com.example.gen.service;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.example.gen.bean.AccountBean;
import com.example.gen.dao.AccountDAO;
import com.example.gen.service.AccountService;
import com.example.gen.util.SessionUtil;

public class AccountService {

	public void  useDetailsSaveOrUpdate(AccountBean bean) {
		AccountDAO dao = new AccountDAO();
		Session session = null;
		try {
			session = SessionUtil.getSession();
			session.getTransaction().begin();
			
			/* Below code save or update record in database table */
			dao.insertAccountDetails(bean);
					
		}catch (HibernateException e) {
			
			e.printStackTrace();
		}finally {
			
			session.getTransaction().commit();
		}
	}
	public static void main(String[] args) {

		AccountService service = new AccountService();
		
		AccountBean bean = new AccountBean();
		bean.setName("SUJAY");
		bean.setBalance(95236);
		bean.setAccCreationDate(new Date());
		
		service.useDetailsSaveOrUpdate(bean);
		
	}

}
