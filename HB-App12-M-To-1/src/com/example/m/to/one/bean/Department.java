package com.example.m.to.one.bean;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "DEPT")
public class Department {

 private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "departmentId")
   
   	@GenericGenerator(name = "id_Sequence", strategy = "increment")
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "id_Sequence")
    private int departmentId;

    @Column(name = "department_name")
    private String department_name;

    @Column(name = "department_location")
    private String location;
    
    public Department() {
        super();
    }

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

    
   }