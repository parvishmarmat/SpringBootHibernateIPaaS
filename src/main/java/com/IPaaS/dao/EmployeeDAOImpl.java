package com.IPaaS.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.IPaaS.model.Employee;

@Repository
@Transactional
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	/*public Employee findById(int id) {
		Employee employee = (Employee)getByKey(id);
		System.out.println(employee.getName());
        return employee;
    }*/
	
	public Employee findById(int id) {

		Employee employee = (Employee) getSession().get(Employee.class, id);
		System.out.println(employee.getName());
		return employee;
	}

	public String saveEmployee(Employee employee) {
        int isSuccess = (int)getSession().save(employee);
        if(isSuccess >= 1){
            return "Success";
        }else{
            return "Error while Saving Person";
        }
         
    }
	
	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployee() {
		List<Employee> list = getSession().createQuery("from employee").list(); 
		return list;
	}
	
	/*public String savePerson(Employee person) {
		Long isSuccess = null;
		try {
			isSuccess = (Long) getSession().save(person);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (isSuccess >= 1) {
			return "Success";
		} else {
			return "Error while Saving Person";
		}
	}

	public boolean delete(Employee person) {
		getSession().delete(person);
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getAllPersons() {
		return getSession().createQuery("from Person").list();
	}*/
}
