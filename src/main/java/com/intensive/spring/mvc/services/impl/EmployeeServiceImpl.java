package com.intensive.spring.mvc.services.impl;

import com.intensive.spring.mvc.dao.EmployeeDAO;
import com.intensive.spring.mvc.dao.PositionDAO;
import com.intensive.spring.mvc.entities.Employee;
import com.intensive.spring.mvc.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private PositionDAO positionDAO;
    private EmployeeDAO employeeDAO;

    @Autowired
    public void setPositionDAO(PositionDAO positionDAO) {
        this.positionDAO = positionDAO;
    }

    @Autowired
    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public void addEmployee(Employee employee) {
        System.out.println("Service: start adding employee" + employee);
        if (employeeDAO == null) System.out.println("employeeDAO = null");
        employee.setPosition(positionDAO.getDefaultPosition());
        employeeDAO.createEmployee(employee);


    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeDAO.updateEmployee(employee);

    }

    @Override
    public List<Employee> listEmployee() {

        return null;
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeDAO.getEmployeeByID(id);
    }

    @Override
    public void removeEmployee(int id) {
        employeeDAO.deleteEmployee(getEmployeeById(id));

    }
}
