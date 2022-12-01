package com.intensive.spring.mvc.dao.impl;

import com.intensive.spring.mvc.components.SessionFactoryBean;
import com.intensive.spring.mvc.dao.EmployeeDAO;
import com.intensive.spring.mvc.entities.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class SQLEmployeeDAO implements EmployeeDAO {
    private SessionFactory sessionFactory;
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void createEmployee(Employee employee) {
        sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().persist(employee);
        sessionFactory.getCurrentSession().getTransaction().commit();
    }

    @Override
    public void updateEmployee(Employee employee) {
        sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().merge(employee);
        sessionFactory.getCurrentSession().getTransaction().commit();
    }

    @Override
    public Employee getEmployeeById(int id) {
        Employee result;
        sessionFactory.getCurrentSession().beginTransaction();
        result =  sessionFactory.getCurrentSession().get(Employee.class, id);
        sessionFactory.getCurrentSession().getTransaction().commit();
        return result;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> result;
        sessionFactory.getCurrentSession().beginTransaction();
        result = sessionFactory.getCurrentSession().createQuery(
                "from Employee",
                Employee.class
        ).
                getResultList();
        sessionFactory.getCurrentSession().getTransaction().commit();
        return result;
    }

    @Override
    public void deleteEmployee(Employee employee) {
        sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().remove(employee);
        sessionFactory.getCurrentSession().getTransaction().commit();
    }
}
