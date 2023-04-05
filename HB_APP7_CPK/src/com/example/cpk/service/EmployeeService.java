package com.example.cpk.service;


import com.example.cpk.dao.EmployeeDAO;
import com.example.model.EmployeeId;

public class EmployeeService {
	
	

	public static void main(String[] args) {

			EmployeeId employeeId = new EmployeeId(100, 90);
			EmployeeDAO employeeDAO = new EmployeeDAO();
			
			employeeDAO.getEmployeeDetails(employeeId);
		
	}

}
