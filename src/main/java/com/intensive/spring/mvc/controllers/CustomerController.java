package com.intensive.spring.mvc.controllers;

import com.intensive.spring.mvc.entities.Customer;
import com.intensive.spring.mvc.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerController {
    private CustomerService customerService;
    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public String listCustomers(Model model) {
        model.addAttribute("entity", new Customer());
        model.addAttribute("entities", this.customerService.getAllCustomer());
        return "customer";
    }

    @RequestMapping(value= "/customer/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("entity") Customer customer){
        this.customerService.addCustomer(customer);
        return "redirect:/customers";

    }

    @RequestMapping("/customer/remove/{id}")
    public String remove(@PathVariable("id") int id){
        this.customerService.removeCustomer(id);
        return "redirect:/customers";
    }

    @RequestMapping("/customer/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model){
        model.addAttribute("entity", this.customerService.getCustomerById(id));
        model.addAttribute("entities", this.customerService.getAllCustomer());
        return "customer";
    }

    @RequestMapping(value = "/customer/update", method = RequestMethod.POST)
    public String update(@RequestParam("name") String name, @RequestParam("id") String id, Model model){
        Customer customer = customerService.getCustomerById(Integer.parseInt(id));
        customer.setName(name);
        customerService.updateCustomer(customer);
        model.addAttribute("entity", new Customer());
        model.addAttribute("entities", this.customerService.getAllCustomer());
        return "customer";
    }
}
