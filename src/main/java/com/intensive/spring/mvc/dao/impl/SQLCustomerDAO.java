package com.intensive.spring.mvc.dao.impl;

import com.intensive.spring.mvc.dao.CustomerDAO;
import com.intensive.spring.mvc.entities.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SQLCustomerDAO implements CustomerDAO {
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void createProject(Customer customer) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(customer);

    }

    @Override
    public Customer getProjectByID(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Customer customer = (Customer) session.getReference(Customer.class, new Integer(id));
        return customer;

    }

    @Override
    public void updateProject(Customer customer) {
        Session session = this.sessionFactory.getCurrentSession();
        session.merge(customer);
    }

    @Override
    public void deleteProject(Customer customer) {
        Session session = this.sessionFactory.getCurrentSession();
        session.remove(customer);
    }
}
