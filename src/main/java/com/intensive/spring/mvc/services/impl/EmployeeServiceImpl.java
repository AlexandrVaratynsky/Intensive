package com.intensive.spring.mvc.services.impl;

import com.intensive.spring.mvc.dao.EmployeeDAO;
import com.intensive.spring.mvc.entities.Employee;
import com.intensive.spring.mvc.services.EmployeeService;
import com.intensive.spring.mvc.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private PositionService positionService;
    private EmployeeDAO employeeDAO;

    @Autowired
    public void setPositionService(PositionService positionService) {
        this.positionService = positionService;
    }

    @Autowired
    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public void addEmployee(Employee employee) {
        employee.setPosition(positionService.getDefaultPosition());
        employeeDAO.createEmployee(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeDAO.updateEmployee(employee);

    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeDAO.getEmployeeById(id);
    }

    @Override
    public void removeEmployee(int id) {
        employeeDAO.deleteEmployee(getEmployeeById(id));

    }
}
