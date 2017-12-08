package com.IPaaS.controller;

import java.util.List;
import java.time.LocalDate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.joda.LocalDateParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.IPaaS.dao.EmployeeDAO;
import com.IPaaS.model.Employee;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeDAO employeeDao;

	@RequestMapping(value = "/getEmployee", method = RequestMethod.GET)
    @ResponseBody
    public Employee getEmployee(){
    	
    	Employee emp = employeeDao.findById(1);
    	System.out.println(emp.getName());
    	
    	return emp;
    }
	
	@RequestMapping(value = "/save", method = RequestMethod.GET)
    @ResponseBody
    public String saveEmployee(){
		Employee employee = new Employee();
		employee.setId(1);
		employee.setName("Dev");
		String result = employeeDao.saveEmployee(employee);
    	System.out.println("Saving Result****"+result);
    	
    	return "";
    }
	
	
	@RequestMapping(value = "/allEmployee")
	@ResponseBody
	public List<Employee> getAllEmployee() {
		try {
			return employeeDao.getAllEmployee();
		} catch (Exception ex) {
			return null;
		}
	}
	
	/*@RequestMapping(value = "/delete")
	@ResponseBody
	public String delete(long id) {
		try {
			Employee person = new Employee();
			person.setId(id);
			personDao.delete(person);
		} catch (Exception ex) {
			return ex.getMessage();
		}
		return "Person succesfully deleted!";
	}

	@RequestMapping(value = "/save")
	@ResponseBody
	public String create(String name, String city) {
		try {
			Employee person = new Employee();
			person.setName(name);
			person.setCity(city);
			personDao.savePerson(person);
		} catch (Exception ex) {
			return ex.getMessage();
		}
		return "Person succesfully saved!";
	}

	@RequestMapping(value = "/allPersons")
	@ResponseBody
	public List<Employee> getAllPersons() {
		try {
			return personDao.getAllPersons();
		} catch (Exception ex) {
			return null;
		}
	}*/
}
