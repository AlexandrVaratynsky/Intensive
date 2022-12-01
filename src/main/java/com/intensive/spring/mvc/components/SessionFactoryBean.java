package com.intensive.spring.mvc.components;

import com.intensive.spring.mvc.entities.Customer;
import com.intensive.spring.mvc.entities.Employee;
import com.intensive.spring.mvc.entities.Position;
import com.intensive.spring.mvc.entities.Project;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class SessionFactoryBean {
    @Bean
    public SessionFactory sessionFactory() {
        SessionFactory sessionFactory = new org.hibernate.cfg.Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Project.class)
                .addAnnotatedClass(Position.class)
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory();
        return sessionFactory;
    }
}