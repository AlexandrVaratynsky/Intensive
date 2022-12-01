package com.intensive.spring.mvc.dao;

import com.intensive.spring.mvc.entities.Customer;

import java.util.List;

public interface CustomerDAO {

    void createCustomer(Customer customer);

    void updateCustomer(Customer customer);

    Customer getCustomerById(int id);

    List<Customer> getAllCustomers();

    void deleteCustomer(Customer customer);
}
