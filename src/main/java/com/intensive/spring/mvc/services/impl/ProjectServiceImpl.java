package com.intensive.spring.mvc.services.impl;

import com.intensive.spring.mvc.dao.ProjectDAO;
import com.intensive.spring.mvc.entities.Customer;
import com.intensive.spring.mvc.entities.Project;
import com.intensive.spring.mvc.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    ProjectDAO projectDAO;
    @Autowired
    public void setProjectDAO(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }

    @Override
    public void addProject(Project project) {
        projectDAO.createProject(project);
    }

    @Override
    public void updateProject(Project project) {
        projectDAO.updateProject(project);
    }

    @Override
    public Project getProjectById(int id) {
        return projectDAO.getProjectById(id);
    }

    @Override
    public List<Project> getAllProject() {
        return projectDAO.getAllProjects();
    }

    @Override
    public void removeProject(int id) {
        projectDAO.deleteProject(getProjectById(id));

    }
}
