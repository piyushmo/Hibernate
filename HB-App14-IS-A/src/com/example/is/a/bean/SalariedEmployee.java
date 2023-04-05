package com.example.is.a.bean;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity

@Table(name = "EMP_SAL")

@AttributeOverrides({
@AttributeOverride(name="eno", column = @Column(name = "EMP_ID") ),	
@AttributeOverride(name="name", column = @Column(name = "EMP_MGR") )})

public class SalariedEmployee extends Employee {

	@Column(name = "salary")
	private double salary;
	
	@Column(name = "bonus")
	private double bonus;

	public SalariedEmployee() {
		
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	@Override
	public String toString() {
		return "SalariedEmployee [salary=" + salary + ", bonus=" + bonus + "]";
	}
}
