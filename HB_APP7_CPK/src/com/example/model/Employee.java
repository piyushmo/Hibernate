package com.example.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEES")
public class Employee {

	@EmbeddedId
	private EmployeeId employee_id;
	
	@Column(name="first_Name")
	private String first_Name;

	@Column(name="deparment_id")
	private String deparment_id;
	
	public Employee() {
		super();
	}
	
	public Employee(EmployeeId employee_id, String first_Name, String deparment_id) {
		super();
		this.employee_id = employee_id;
		this.first_Name = first_Name;
		this.deparment_id = deparment_id;
	}
	public EmployeeId getEid() {
		return employee_id;
	}
	public void setEid(EmployeeId employee_id) {
		this.employee_id = employee_id;
	}
	public String getEmpName() {
		return first_Name;
	}
	public void setEmpName(String first_Name) {
		this.first_Name = first_Name;
	}
	public String getDeptName() {
		return deparment_id;
	}
	public void setDeptName(String deparment_id) {
		this.deparment_id = deparment_id;
	}
	
	@Override
	public String toString() {
		return "Employee [eid=" + employee_id + ", empName=" + first_Name + ", deptName=" + deparment_id + "]";
	}
}
