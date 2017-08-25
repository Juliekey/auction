package com.project.app.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping({"/", "/home"})
@RestController
public class HomeController {
    @RequestMapping(method = RequestMethod.GET)
    public String home() {
        return "home page";
    }

}
