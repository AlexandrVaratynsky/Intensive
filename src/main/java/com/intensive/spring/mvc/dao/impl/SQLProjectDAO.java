package com.intensive.spring.mvc.dao.impl;

import com.intensive.spring.mvc.dao.ProjectDAO;
import com.intensive.spring.mvc.entities.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SQLProjectDAO implements ProjectDAO {

    private SessionFactory sessionFactory;


    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void createProject(Project project) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(project);

    }

    @Override
    public Project getProjectByID(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Project project = (Project) session.getReference(Project.class, new Integer(id));
        return project;

    }

    @Override
    public void updateProject(Project project) {
        Session session = this.sessionFactory.getCurrentSession();
        session.merge(project);
    }

    @Override
    public void deleteProject(Project project) {
        Session session = this.sessionFactory.getCurrentSession();
        session.remove(project);
    }
}
