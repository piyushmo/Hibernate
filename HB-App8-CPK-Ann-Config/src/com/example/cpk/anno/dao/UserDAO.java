package com.example.cpk.anno.dao;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.cpk.anno.bean.User;
import com.example.cpk.anno.bean.UserPK;
import com.example.cpk.anno.util.SessionUtil;

public class UserDAO {
	
	public User getUserDetails(UserPK user) {
		
		Session session = null;
		User bean = null;
		
		try {
			
			session=SessionUtil.getSession();
			bean = (User)session.get(User.class, user);
			
			System.out.println(bean);
			
		}catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			
			SessionUtil.closeSession(session);
		}
		
		return bean;
	}

	
	public void insertStudentDetails(User bean) {
		
		Session session = null;
		
		try {
			
			session = SessionUtil.getSession();
			session.getTransaction().begin();
			session.save(bean);
			session.getTransaction().commit();
			
		}catch (HibernateException e) {
			
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			
			SessionUtil.closeSession(session);
		}
		
	}
	
	
	public void updateStudentDetails(User bean) {
		
		Session session = null;
		
		try {
			
			session = SessionUtil.getSession();
			session.getTransaction().begin();
			session.update(bean);
			session.getTransaction().commit();
			
		}catch (HibernateException e) {
			
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			
			SessionUtil.closeSession(session);
		}
	}
	
	public void deleteStudentDetails(UserPK user) {
		
		Session session = null;
		Transaction transaction = null;
		
		try {
			session = SessionUtil.getSession();
			transaction = session.getTransaction();
			User accountBean = (User)session.get(User.class, user);
			session.delete(accountBean);
			transaction.commit();
		}catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			
		}finally {
			
			SessionUtil.closeSession(session);
		}	
	}
}