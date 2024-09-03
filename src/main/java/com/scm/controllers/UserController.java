package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/user")
public class UserController {
    // 1. user dashboard page
    @RequestMapping(value = "/dashboard")
    public String userDashboard() {
        return "user/dashboard";
    }

    // user profile page
    @RequestMapping(value = "/profile")
    public String userProfile() {
        return "user/profile";
    }
    
    // 2. user add contact page
    
    // 3. user view contacts 
    // 4. user edit contact page
    // 5. user delete contact page
    //  6. user search contact
}
