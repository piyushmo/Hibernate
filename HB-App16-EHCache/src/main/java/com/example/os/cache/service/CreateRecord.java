package com.example.os.cache.service;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.example.os.cache.bean.Address;
import com.example.os.cache.bean.Employee;
import com.example.os.cache.util.HibernateUtil;


public class CreateRecord {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		
		Address address = new Address();
		address.setAddressLine1("Sarkarwada");
		address.setCity("Suyog");
		address.setZipcode("413525");
        
        Employee emp = new Employee();
        emp.setName("Kulkarni");
        emp.setSalary(105000);
        
        emp.setAddress(address);
        address.setEmployee(emp);
        //Save Employee
        session.save(emp);

        tx.commit();
       session.close();
      
		
	}

}
