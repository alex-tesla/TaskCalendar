package com.devsav.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.devsav.service.interfaces.PeopleService;

import javax.servlet.annotation.WebInitParam;


@Controller
@WebInitParam(name = "notification", value = "off")
public class LoginController {
    private static final Logger LOGGER = Logger.getLogger(LoginController.class);


    @Autowired
    private PeopleService peopleService;

    @Autowired
    public void setPeopleService(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPage() {
        return "login";
    }


}