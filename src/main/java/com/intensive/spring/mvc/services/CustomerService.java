package com.intensive.spring.mvc.services;

import com.intensive.spring.mvc.entities.Customer;
import com.intensive.spring.mvc.entities.Employee;

import java.util.List;

public interface CustomerService {
    public void addCustomer(Customer customer);
    public void updateCustomer(Customer customer);
    public Customer getCustomerById(int id);
    public List<Customer> getAllCustomer();
    public void removeCustomer(int id);
}
