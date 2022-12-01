package com.intensive.spring.mvc.dao;

import com.intensive.spring.mvc.entities.Employee;
import org.hibernate.SessionFactory;

import java.util.List;

public interface EmployeeDAO {
    public void setSessionFactory(SessionFactory sessionFactory);
    void createEmployee(Employee employee);

    Employee getEmployeeById(int id);

    void updateEmployee(Employee employee);

    List<Employee> getAllEmployees();

    void deleteEmployee(Employee employee);
}
