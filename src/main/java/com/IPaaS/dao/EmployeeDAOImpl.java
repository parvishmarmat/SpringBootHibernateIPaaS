package com.IPaaS.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.IPaaS.dao.HibernateUtil;
import com.IPaaS.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	private Session session = HibernateUtil.getSessionFactory().openSession();

	private Session getSession() {
		session.beginTransaction();
		return session;
	}

	public Employee findById(int id) {

		Employee employee = (Employee) getSession().get(Employee.class, id);
		System.out.println(employee.getName());
		return employee;
	}

	public String saveEmployee(Employee employee) {
		int isSuccess = (int) getSession().save(employee);
		session.getTransaction().commit();
		
		if (isSuccess >= 1) {
			return "Success";
		} else {
			return "Error while Saving Person";
		}

	}

	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployee() {
		List<Employee> list = getSession().createQuery("from employee").list();
		return list;
	}

}
