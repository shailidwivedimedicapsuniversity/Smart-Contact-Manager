package com.scm.controllers;

import javax.naming.Binding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.helpers.Message;
import com.scm.helpers.MessageType;
import com.scm.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class PageController {
    // 3 routes , home about services
    // home
    @Autowired
    private UserService userService;

    // private User saveUser;

    @RequestMapping("/home")
    public String home(Model model) {
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
    public String about() {
        System.out.println("About the page ");
        return "about";
    }

    // services
    @RequestMapping("/services")
    public String services(Model model) {
        model.addAttribute("isLogin", false);
        System.out.println("service page loading");
        return "services";
    }

    // contact route
    @GetMapping("/contact")
    public String contact() {

        return new String("contact");
    }

    @GetMapping("/login")
    public String login() {

        return new String("login");
    }

    @GetMapping("/register")
    public String register(Model model) {
        UserForm userForm = new UserForm();
        // userForm.setName("Shaili Dwivedi");
        // userForm.setAbout("hii i am shaili");
        model.addAttribute("userForm", userForm);
        return "register";
    }

    // processing register
    @RequestMapping(value = "/do-register", method = RequestMethod.POST)
    public String processRegister(@Valid @ModelAttribute UserForm userForm, BindingResult rBindingResult, HttpSession session) {
        System.out.println("working fine");
        // fetch form data
        System.out.println(userForm);
        // send to model
        // Todo : validate user form data
        if(rBindingResult.hasErrors()){
            return "register";
        }

        // save to database

        // userservice
        // created user from userform and put all data of userform in user
    
        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNum(userForm.getPhoneNum());
        user.setEnabled(false);
        user.setProfileLink("https://shailidwivedipersonalportfolio.netlify.app/img/profile.jpg");

        User savedUser = userService.saveUser(user);
        Message message = Message.builder().content("sucessfully created account").type(MessageType.green).build();
        // message : sucess
      session.setAttribute("message",message );
        // redirect to login page
        return "redirect:/register";
    }
}
