package com.example.m.to.one.service;

import javax.transaction.Transaction;

import org.hibernate.Session;

import com.example.m.to.one.bean.Department;
import com.example.m.to.one.bean.Employee;
import com.example.m.to.one.util.SessionUtil;

public class CreateDAO {

	public static void main(String[] args) {

		try {
			Session session = SessionUtil.getSession();
			session.getTransaction().begin();

			Department department = new Department();
			department.setDepartment_name("Financial Services");
			department.setLocation("Hyderabad");

			Employee employee = new Employee();
			
			employee.setFirstName("Nitin");
			employee.setLastName("Kolte");
			employee.setDepartment(department);

			Employee employee1 = new Employee();
			employee1.setFirstName("Devish");
			employee1.setLastName("Singh");
			employee1.setDepartment(department);

			Employee employee2 = new Employee();
			employee2.setFirstName("Apoorav");
			employee2.setLastName("Sigh");
			employee2.setDepartment(department);

			session.save(employee);

			session.save(employee1);
			session.save(employee2);

			session.getTransaction().commit();
			SessionUtil.closeSession(session);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
