package com.intensive.spring.mvc.services;

import com.intensive.spring.mvc.entities.Project;

import java.util.List;

public interface ProjectService {
    public void addProject(Project project);
    public void updateProject(Project project);
    public Project getProjectById(int id);
    public List<Project> getAllProject();
    public void removeProject(int id);
}
