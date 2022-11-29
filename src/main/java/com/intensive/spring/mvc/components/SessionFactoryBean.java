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

//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.ImportResource;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
////@Configuration
////@EnableTransactionManagement
////@ImportResource({"classpath:hibernate.cfg.xml"})
////public class SessionFactoryBean {
////
////}
//
//import java.util.Properties;
//import javax.sql.DataSource;
//
//import com.intensive.spring.mvc.entities.Customer;
//import com.intensive.spring.mvc.entities.Employee;
//import com.intensive.spring.mvc.entities.Position;
//import com.intensive.spring.mvc.entities.Project;
//
//import org.hibernate.SessionFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.orm.hibernate5.HibernateTransactionManager;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//@Configuration
//@EnableTransactionManagement
//public class SessionFactoryBean {
//    @Bean
//    public SessionFactory sessionFactory() {
//        SessionFactory sessionFactory = new org.hibernate.cfg.Configuration()
//                .configure("hibernate.cfg.xml")
//                .addAnnotatedClass(Employee.class)
//                .addAnnotatedClass(Project.class)
//                .addAnnotatedClass(Position.class)
//                .addAnnotatedClass(Customer.class)
//                .buildSessionFactory();
//
//        return sessionFactory;
//    }
//}
////    @Bean
////    public DataSource dataSource() {
////        BasicDataSource dataSource = new BasicDataSource();
////        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
////        dataSource.setUrl("jdbc:mysql://localhost:3306/test_connection");
////        dataSource.setUsername("root");
////        dataSource.setPassword("root");
////        return dataSource;
////    }
//    @Bean
//    public PlatformTransactionManager hibernateTransactionManager() {
//        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
//        transactionManager.setSessionFactory(sessionFactory());
//        return transactionManager;
//    }
//    private final Properties hibernateProperties() {
//        Properties hibernateProperties = new Properties();
//
//        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
//        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
//        return hibernateProperties;
//    }
//}


//package com.intensive.spring.mvc.components;
//
//import com.intensive.spring.mvc.entities.Customer;
//import com.intensive.spring.mvc.entities.Employee;
//import com.intensive.spring.mvc.entities.Position;
//import com.intensive.spring.mvc.entities.Project;
//import org.hibernate.SessionFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class SessionFactoryBean {
//
//
//    @Bean
//    public SessionFactory getSessionFactory() {
//        SessionFactory sessionFactory = new org.hibernate.cfg.Configuration()
//                .configure("hibernate.cfg.xml")
//                .addAnnotatedClass(Employee.class)
//                .addAnnotatedClass(Project.class)
//                .addAnnotatedClass(Position.class)
//                .addAnnotatedClass(Customer.class)
//                .buildSessionFactory();
//
//        return sessionFactory;
//    }
//
//}

