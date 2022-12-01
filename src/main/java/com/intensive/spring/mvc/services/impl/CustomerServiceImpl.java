package com.intensive.spring.mvc.services.impl;

import com.intensive.spring.mvc.dao.CustomerDAO;
import com.intensive.spring.mvc.entities.Customer;
import com.intensive.spring.mvc.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    CustomerDAO customerDAO;

    @Autowired
    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    public void addCustomer(Customer customer) {
        customerDAO.createCustomer(customer);

    }

    @Override
    public void updateCustomer(Customer customer) {
        customerDAO.updateCustomer(customer);
    }

    @Override
    public Customer getCustomerById(int id) {
        return customerDAO.getCustomerById(id);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerDAO.getAllCustomers();
    }

    @Override
    public void removeCustomer(int id) {
        customerDAO.deleteCustomer(getCustomerById(id));
    }
}

