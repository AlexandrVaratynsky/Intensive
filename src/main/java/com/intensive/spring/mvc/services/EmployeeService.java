package com.intensive.spring.mvc.services;

import com.intensive.spring.mvc.entities.Employee;

import java.util.List;

public interface EmployeeService {
    public void addEmployee(Employee employee);
    public void updateEmployee(Employee employee);
    public List<Employee> listEmployee();
    public Employee getEmployeeById(int id);
    public void removeEmployee(int id);
}
