package com.example.cpk.dao;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.model.Employee;
import com.example.model.EmployeeId;
import com.example.cpk.util.SessionUtil;

public class EmployeeDAO {
	
	public Employee getEmployeeDetails(EmployeeId empId) {
		
		Session session = null;
		Employee bean = null;
		
		try {
			
			session=SessionUtil.getSession();
			bean = (Employee)session.get(Employee.class, empId);
			
		}catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			
			SessionUtil.closeSession(session);
		}
		
		return bean;
	}

	
	public void insertAccountDetails(Employee bean) {
		
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
	
	
	public void updateEmployeeDetails(Employee bean) {
		
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
	
	public void deleteAccountDetails(long accNo) {
		
		Session session = null;
		Transaction transaction = null;
		
		try {
			session = SessionUtil.getSession();
			transaction = session.getTransaction();
			Employee accountBean = (Employee)session.get(Employee.class, accNo);
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