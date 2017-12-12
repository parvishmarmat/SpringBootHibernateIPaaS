package com.IPaaS.controller;

import java.util.Date;
import java.util.List;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
    public Employee getEmployee(@PathVariable int id){
    	
    	Employee emp = employeeDao.findById(id);
    	System.out.println(emp.getName());
    	
    	return emp;
    }
	
	@RequestMapping(value = "/save", method = RequestMethod.GET)
    @ResponseBody
    public String saveEmployee(@RequestBody Employee employee){
//		Employee employee = new Employee();
//		employee.setName("Ram");
//		employee.setSalary(new BigDecimal(30000));
//		employee.setJoiningDate(new Date());
		
		String result = employeeDao.saveEmployee(employee);
    	System.out.println("Saving Result****"+result);
    	
    	return result;
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

}
