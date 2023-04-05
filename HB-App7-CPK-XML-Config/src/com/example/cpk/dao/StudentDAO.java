package com.example.cpk.dao;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.cpk.bean.Student;
import com.example.cpk.util.SessionUtil;

public class StudentDAO {
	
	public Student getStudentDetails(Student student) {
		
		Session session = null;
		Student bean = null;
		
		try {
			
			session=SessionUtil.getSession();
			bean = (Student)session.get(Student.class, student);
			
			System.out.println(bean);
			
		}catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			
			SessionUtil.closeSession(session);
		}
		
		return bean;
	}

	
	public void insertStudentDetails(Student bean) {
		
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
	
	
	public void updateStudentDetails(Student bean) {
		
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
	
	public void deleteStudentDetails(Student student) {
		
		Session session = null;
		Transaction transaction = null;
		
		try {
			session = SessionUtil.getSession();
			transaction = session.getTransaction();
			Student accountBean = (Student)session.get(Student.class, student);
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