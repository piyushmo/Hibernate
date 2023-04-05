package com.example.one.to.many.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.transaction.Transaction;

import org.hibernate.Session;

import com.example.one.to.many.bean.Department;
import com.example.one.to.many.bean.Employee;
import com.example.one.to.many.util.SessionUtil;

public class RetriveDAO {

	public static void main(String[] args) {

		try {
			Session session = SessionUtil.getSession();
			session.getTransaction().begin();

			Employee employee = (Employee)session.get(Employee.class, 1);
			
			Department department = employee.getDepartment();
			
			System.out.println("Department Details .. : ");
			System.out.println("Department No .. : "+department.getDepartmentId());
			System.out.println("Department Name .. : "+department.getDepartment_name());
			System.out.println("Department Location .. : "+department.getLocation());
			System.out.println("Department Employee Name .. : ");
			
			List<Employee> employees = department.getEmployeeList();
			employees.stream().forEach(emp -> System.out.println(employee.getFirstName()
													   + " - " + employee.getLastName()
													   + " - " + employee.getEmployeeId()));

			session.getTransaction().commit();
			SessionUtil.closeSession(session);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
