package com.IPaaS.dao;

import java.util.List;

import com.IPaaS.model.Employee;

public interface EmployeeDAO {

//	String savePerson(Employee person);
//	boolean delete(Employee person);
//	List<Employee> getAllPersons();
	
	Employee findById(int id);
	String saveEmployee(Employee employee);
	List<Employee> getAllEmployee();
}
