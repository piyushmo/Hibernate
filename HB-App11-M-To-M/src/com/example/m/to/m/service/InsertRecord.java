package com.example.m.to.m.service;

import org.hibernate.Session;

import com.example.m.to.m.bean.Employee;
import com.example.m.to.m.bean.Project;
import com.example.m.to.m.util.SessionUtil;


public class InsertRecord {
    public static void main(String[] args) {
        Session session = SessionUtil.getSession();
        session.beginTransaction();

        // Create an employee
        Employee employee = new Employee();
        employee.setFirstName("Ramesh");
        employee.setLastName("Fadatare");

       // Create project1
        Project project = new Project();
        project.setTitle("Employee Management System");

        // Create project2
       Project project1 = new Project();
       project1.setTitle("Content Management System");

       // employee can work on two projects, Add project references in the employee
       employee.getProjects().add(project);
       employee.getProjects().add(project1);

        // Add employee reference in the projects
       project.getEmployees().add(employee);
       project1.getEmployees().add(employee);

       session.save(employee);

       session.getTransaction().commit();
       SessionUtil.closeSession(session);;
    }
}

