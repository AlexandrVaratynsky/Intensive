package com.intensive.spring.mvc.dao.impl;

import com.intensive.spring.mvc.components.SessionFactoryBean;
import com.intensive.spring.mvc.dao.EmployeeDAO;
import com.intensive.spring.mvc.entities.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SQLEmployeeDAO implements EmployeeDAO {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    @Autowired
    public void setSessionFactory(SessionFactoryBean sessionFactoryBean){
        this.sessionFactory = sessionFactoryBean.sessionFactory();
    }

    public SQLEmployeeDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public void createEmployee(Employee employee) {
        System.out.println("DAO: start adding employee" + employee);
        Session session = this.sessionFactory.getCurrentSession();
        System.out.println("session " + session.toString());
        session.beginTransaction();
        session.persist(employee);
        session.getTransaction().commit();

    }

    @Override
    public Employee getEmployeeByID(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Employee employee = (Employee) session.getReference(Employee.class, new Integer(id));
        return employee;

    }

    @Override
    public void updateEmployee(Employee employee) {
        Session session = this.sessionFactory.getCurrentSession();
        session.merge(employee);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        Session session = this.sessionFactory.getCurrentSession();
        session.remove(employee);
    }

    @Override
    public List<Employee> getEmployees() {
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Employee> employeeList = session.createQuery("from Employee").getResultList();
        session.getTransaction().commit();
        return employeeList;
    }
}
