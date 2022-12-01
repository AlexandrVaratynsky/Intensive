package com.intensive.spring.mvc.controllers;

import com.intensive.spring.mvc.entities.Position;
import com.intensive.spring.mvc.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PositionController {
    private PositionService positionService;
    @Autowired
    public void setPositionService(PositionService positionService) {
        this.positionService = positionService;
    }

    @RequestMapping(value = "/positions")
    public String listPositions(Model model) {
        model.addAttribute("entity", new Position());
        model.addAttribute("entities", this.positionService.getAllPositions());
        return "position";
    }

    @RequestMapping(value= "/position/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("entity") Position position){
        this.positionService.addPosition(position);
        return "redirect:/positions";
    }

    @RequestMapping("/position/remove/{id}")
    public String remove(@PathVariable("id") int id){
        this.positionService.removePosition(id);
        return "redirect:/positions";
    }

    @RequestMapping("/position/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model){
        model.addAttribute("entity", this.positionService.getPositionById(id));
        model.addAttribute("entities", this.positionService.getAllPositions());
        return "position";
    }
    @RequestMapping(value = "/position/update", method = RequestMethod.POST)
    public String update(@RequestParam("name") String name, @RequestParam("id") String id, Model model){
        Position position = positionService.getPositionById(Integer.parseInt(id));
        position.setName(name);
        positionService.updatePosition(position);
        model.addAttribute("entity", new Position());
        model.addAttribute("entities", this.positionService.getAllPositions());
        return "position";
    }
}
