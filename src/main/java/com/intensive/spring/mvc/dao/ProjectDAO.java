package com.intensive.spring.mvc.dao;

import com.intensive.spring.mvc.entities.Project;

import java.util.List;

public interface ProjectDAO {

    void createProject(Project project);

    void updateProject(Project project);

    Project getProjectById(int id);

    List<Project> getAllProjects();

    void deleteProject(Project project);
}
