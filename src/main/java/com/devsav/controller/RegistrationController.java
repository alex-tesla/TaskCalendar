package com.devsav.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.devsav.common.exception.PeopleDAOException;
import com.devsav.service.interfaces.PeopleService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RegistrationController {
    private static final Logger LOGGER = Logger.getLogger(RegistrationController.class);

    @Autowired
    private HttpServletRequest request;

    private PeopleService peopleService;

    @Autowired
    public void setPeopleServiceImpl(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String showRegistrationPage() {
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registrationPeople(@RequestParam String firstname,
                                     @RequestParam String lastname,
                                     @RequestParam String email,
                                     @RequestParam String login,
                                     @RequestParam String password) {
        try {
            if(peopleService.registration(firstname, lastname, email, login, password)) {
                LOGGER.trace("true");
                return "login";
            } else {
                LOGGER.trace("false");
                return "error";
            }
        } catch (PeopleDAOException e) {
            return "error";
        }
    }
}