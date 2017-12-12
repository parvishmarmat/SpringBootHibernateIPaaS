package com.IPaaS.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@Column(name = "EMP_ID")
    @GeneratedValue
    private int id;
 
    @Column(name = "NAME")
    private String name;
 
    @Column(name = "JOINING_DATE")
    private Date joiningDate;
 
    @Column(name = "SALARY")
    private BigDecimal salary;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date date) {
		this.joiningDate = date;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Employee [eid=" + id + ", eName=" + name + ", jDate=" + joiningDate + ", salary =" + salary +"]";
	}
}
