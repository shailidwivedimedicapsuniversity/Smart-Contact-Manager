package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    // 3 routes , home about services
    // home
    @RequestMapping("/home")
    public String home(Model model){
        System.out.println("home page");
        // passing dynamic data 
        // sending data to view
        model.addAttribute("fname", "shaili");
        model.addAttribute("lname", "dwivedi");
        model.addAttribute("github", "https://github.com/shailidwivedimedicapsuniversity?tab=repositories");
        model.addAttribute("youtube", "https://www.youtube.com/@LearnCodeWithDurgesh");
        model.addAttribute("linkdin", "https://www.linkedin.com/in/shaili-dwivedi05/");

        return "home";
    }

    // about route
    @RequestMapping("/about")
    public String about(){
        System.out.println("About the page ");
        return "about";
    }

    // services
    @RequestMapping("/services")
    public String services(Model model){
        model.addAttribute("isLogin",false);
        System.out.println("service page loading");
        return "services";
    }

    // contact route
    @GetMapping("/contact")
    public String contact(){

        return new String("contact");
    }

    @GetMapping("/login")
    public String login(){

        return new String("login");
    }

    @GetMapping("/register")
    public String register(){

        return new String("register");
    }

}
