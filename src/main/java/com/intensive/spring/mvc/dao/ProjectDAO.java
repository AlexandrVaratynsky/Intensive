package com.intensive.spring.mvc.dao;

import com.intensive.spring.mvc.entities.Project;

public interface ProjectDAO {
    public void createProject(Project project);
    public Project getProjectByID(int id);
    public void updateProject(Project project);
    public void deleteProject(Project project);
}
