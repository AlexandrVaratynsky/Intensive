package com.intensive.spring.mvc.dao;

import com.intensive.spring.mvc.entities.Customer;

public interface CustomerDAO {
    void createProject(Customer customer);

    Customer getProjectByID(int id);

    void updateProject(Customer customer);

    void deleteProject(Customer customer);
}
