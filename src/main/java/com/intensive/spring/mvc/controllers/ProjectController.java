package com.intensive.spring.mvc.controllers;

import com.intensive.spring.mvc.entities.Project;
import com.intensive.spring.mvc.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProjectController {
    private ProjectService projectService;
    @Autowired
    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    @RequestMapping(value = "/projects", method = RequestMethod.GET)
    public String listProjects(Model model) {
        model.addAttribute("entity", new Project());
        model.addAttribute("entities", this.projectService.getAllProject());
        return "project";
    }

    @RequestMapping(value= "/projects/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("entity") Project project){
        this.projectService.addProject(project);
        return "redirect:/projects";

    }

    @RequestMapping("/projects/remove/{id}")
    public String remove(@PathVariable("id") int id){
        this.projectService.removeProject(id);
        return "redirect:/projects";
    }

    @RequestMapping("/projects/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model){
        model.addAttribute("entity", this.projectService.getProjectById(id));
        model.addAttribute("entities", this.projectService.getAllProject());
        return "project";
    }

}
