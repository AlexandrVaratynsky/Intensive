package com.intensive.spring.mvc.controllers;

import com.intensive.spring.mvc.entities.Employee;
import com.intensive.spring.mvc.entities.Position;
import com.intensive.spring.mvc.services.EmployeeService;
import com.intensive.spring.mvc.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {
    private PositionService positionService;
    private EmployeeService employeeService;
    @Autowired
    public void setPositionService(PositionService positionService) {
        this.positionService = positionService;
    }
    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public String listEmployees(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("listEmployees", this.employeeService.getAllEmployees());
        model.addAttribute("listPositions", this.positionService.getAllPositions());
        return "employee";
    }

    @RequestMapping(value= "/employee/add", method = RequestMethod.POST)
    public String addEmployee(@ModelAttribute("employee") Employee employee){
        this.employeeService.addEmployee(employee);
        return "redirect:/employees";

    }

    @RequestMapping("/employee/remove/{id}")
    public String removeEmployee(@PathVariable("id") int id){
        this.employeeService.removeEmployee(id);
        return "redirect:/employees";
    }

    @RequestMapping("/employee/edit/{id}")
    public String editEmployee(@PathVariable("id") int id, Model model){
        model.addAttribute("employee", this.employeeService.getEmployeeById(id));
        model.addAttribute("listEmployees", this.employeeService.getAllEmployees());
        return "employee";
    }

    @RequestMapping(value = "/employee/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("employee") Employee employee,
                         Model model){
        Employee emp = employeeService.getEmployeeById(employee.getId());
        emp.setFirstName(employee.getFirstName());
        emp.setLastName(employee.getLastName());
        employeeService.updateEmployee(emp);
        model.addAttribute("employee", new Employee());
        model.addAttribute("employees", this.employeeService.getAllEmployees());
        return "employee";
    }
}
