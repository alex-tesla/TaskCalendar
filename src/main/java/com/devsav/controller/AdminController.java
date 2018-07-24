package com.devsav.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.devsav.common.exception.PeopleDAOException;
import com.devsav.model.pojo.People;
import com.devsav.service.interfaces.PeopleService;


import java.security.Principal;
import java.util.List;

@Controller
public class AdminController {
    private static final Logger LOGGER = Logger.getLogger(AdminController.class);

    private final PeopleService peopleService;

    @Autowired
    public AdminController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @RequestMapping(value = "/admin/panel", method = RequestMethod.GET)
    public ModelAndView getAllPeoples(Principal principal) throws PeopleDAOException {
        List<People> listOfPeoples;
        ModelAndView modelAndView = new ModelAndView("admin");

        try {
            listOfPeoples = peopleService.getAllPeoples();
            modelAndView.addObject("listOfPeoples", listOfPeoples);
        } catch (PeopleDAOException e) {
            LOGGER.error(e);
            return new ModelAndView("error");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/admin/edit", method = RequestMethod.GET)
    public ModelAndView getPeopleById(@RequestParam int id) {
        People people;
        try {
           people = peopleService.getPeopleById(id);
        } catch (PeopleDAOException e) {
            LOGGER.error(e);
            return new ModelAndView("error");
        }
        return new ModelAndView("people_edit", "people", people);
    }

    @RequestMapping(value = "/admin/edit", method = RequestMethod.POST)
    public ModelAndView editPeople(@ModelAttribute("people") People people) {
        try {
            peopleService.updatePeople(people);

        } catch (PeopleDAOException e) {
            LOGGER.error(e);
        }
        return new ModelAndView("redirect:/admin/panel");
    }
}