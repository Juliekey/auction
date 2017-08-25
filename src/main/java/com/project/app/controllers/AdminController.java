package com.project.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/admin")
@RestController
public class AdminController {

    @RequestMapping(method = RequestMethod.GET)
    public String adminHomePage() {
    return "Hello, Admin";
    }
}
