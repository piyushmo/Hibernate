package com.example.is.a.service;

import org.hibernate.Session;

import com.example.is.a.bean.Employee;
import com.example.is.a.bean.HourlyBasisEmployee;
import com.example.is.a.bean.SalariedEmployee;
import com.example.is.a.util.SessionUtil;

public class CreateDAO {

	public static void main(String[] args) {
		
		Session session = SessionUtil.getSession();
		session.getTransaction().begin();

		Employee employee =  new Employee();
		employee.setName("Suyog");
		
		SalariedEmployee salariedEmployee = new SalariedEmployee();
		salariedEmployee.setName("Vijay");
		salariedEmployee.setSalary(97000);
		salariedEmployee.setBonus(70000);
		//salariedEmployee.setName(employee.getName());
		
		HourlyBasisEmployee hourlyBasisEmployee = new HourlyBasisEmployee();
		hourlyBasisEmployee.setName("Ram");
		hourlyBasisEmployee.setWork_hours(9);
		hourlyBasisEmployee.setPayout(2700);
		//hourlyBasisEmployee.setName(employee.getName());
		
		session.save(employee);
		session.save(salariedEmployee);
		session.save(hourlyBasisEmployee);
		
		session.getTransaction().commit();
	    SessionUtil.closeSession(session);
	}

}
