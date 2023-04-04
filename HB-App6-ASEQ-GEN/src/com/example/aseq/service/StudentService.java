package com.example.aseq.service;


import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.example.aseq.bean.Student;
import com.example.aseq.dao.StudentDAO;
import com.example.aseq.util.SessionUtil;

public class StudentService {

	public void  studentDetailsSaveOrUpdate(Student bean) {
		StudentDAO dao = new StudentDAO();
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

		StudentService studentService = new StudentService();
		Student bean = new Student();
		bean.setName("Ramesh");
		bean.setCourse("MCA");
		bean.setFees(1500);
		studentService.studentDetailsSaveOrUpdate(bean);
		
	}

}
