package com.example.is.a.bean;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity

@Table(name = "HOUR_EMP")

@AttributeOverride(name="name", column = @Column(name = "EMP_MGR") )	

public class HourlyBasisEmployee extends Employee {

	@Column(name = "work_hours")
	private int work_hours;
	
	@Column(name = "payout")
	private double payout;

	public int getWork_hours() {
		return work_hours;
	}

	public void setWork_hours(int work_hours) {
		this.work_hours = work_hours;
	}

	public double getPayout() {
		return payout;
	}

	public void setPayout(double payout) {
		this.payout = payout;
	}

	public HourlyBasisEmployee() {
		super();
	}

	@Override
	public String toString() {
		return "HourlyBasisEmployee [work_hours=" + work_hours + ", payout=" + payout + "]";
	}
	
}
