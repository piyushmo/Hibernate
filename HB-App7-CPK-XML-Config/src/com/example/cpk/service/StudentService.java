package com.example.cpk.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.cpk.bean.Student;
import com.example.cpk.dao.StudentDAO;
import com.example.cpk.util.SessionUtil;

public class StudentService {

	public static void main(String[] args) {

		Student student = new Student();

		/*
		 * student.setStudentId(109); student.setStudentAddress("Hyd");
		 * student.setStudentName("Swapnil"); student.setCourceId(205);
		 */

		StudentDAO dao = new StudentDAO();
		//dao.insertStudentDetails(student);

		student.setCourceId(205);
		student.setStudentId(103);
		dao.getStudentDetails(student);

		/* Display account details after Retrieving from DAO layer */
		System.out.println("Student Details .. : ");
		System.out.println("Student No .. : " + student.getStudentId());
		System.out.println("Student Name .. : " + student.getStudentName());
		System.out.println("Student Address .. : " + student.getStudentAddress());
		System.out.println("Student CourceId .. : " + student.getCourceId());

	}

}
