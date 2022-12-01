package com.intensive.spring.mvc.dao.impl;

import com.intensive.spring.mvc.dao.CustomerDAO;
import com.intensive.spring.mvc.entities.Customer;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class SQLCustomerDAO implements CustomerDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void createCustomer(Customer customer) {
        sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().persist(customer);
        sessionFactory.getCurrentSession().getTransaction().commit();
    }

    @Override
    public void updateCustomer(Customer customer) {
        sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().merge(customer);
        sessionFactory.getCurrentSession().getTransaction().commit();
    }

    @Override
    public Customer getCustomerById(int id) {
        Customer result;
        sessionFactory.getCurrentSession().beginTransaction();
        result = sessionFactory.getCurrentSession().get(Customer.class, id);
        sessionFactory.getCurrentSession().getTransaction().commit();
        return result;
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> result;
        sessionFactory.getCurrentSession().beginTransaction();
        result = sessionFactory.getCurrentSession().createQuery(
                        "from Customer",
                        Customer.class
                )
                .getResultList();
        sessionFactory.getCurrentSession().getTransaction().commit();
        return result;
    }

    @Override
    public void deleteCustomer(Customer customer) {
        sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().remove(customer);
        sessionFactory.getCurrentSession().getTransaction().commit();
    }
}
