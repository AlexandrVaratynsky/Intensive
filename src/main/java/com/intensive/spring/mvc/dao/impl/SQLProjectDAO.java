package com.intensive.spring.mvc.dao.impl;

import com.intensive.spring.mvc.dao.ProjectDAO;
import com.intensive.spring.mvc.entities.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SQLProjectDAO implements ProjectDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void createProject(Project project) {
        sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().persist(project);
        sessionFactory.getCurrentSession().getTransaction().commit();
    }

    @Override
    public void updateProject(Project project) {
        sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().merge(project);
        sessionFactory.getCurrentSession().getTransaction().commit();
    }

    @Override
    public Project getProjectById(int id) {
        Project result;
        sessionFactory.getCurrentSession().beginTransaction();
        result = sessionFactory.getCurrentSession().get(Project.class, id);
        sessionFactory.getCurrentSession().getTransaction().commit();
        return result;
    }

    @Override
    public List<Project> getAllProjects(){
        List<Project> result;
        sessionFactory.getCurrentSession().beginTransaction();
        result = sessionFactory.getCurrentSession().createQuery(
                "from Project ",
                Project.class)
                .getResultList();
        sessionFactory.getCurrentSession().getTransaction().commit();
        return result;
    }

    @Override
    public void deleteProject(Project project) {
        sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().remove(project);
        sessionFactory.getCurrentSession().getTransaction().commit();
    }
}
