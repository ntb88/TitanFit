package com.CapstoneApp.TitanFit.Controller;

import com.CapstoneApp.TitanFit.Model.AppUser;
import com.CapstoneApp.TitanFit.Model.Role;
import com.CapstoneApp.TitanFit.Repository.AppUserRepository;
import com.CapstoneApp.TitanFit.Service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController {

    @Autowired
    AppUserService appUserService;

    // Show the login form
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    // Show the registration page
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new AppUser());  // Pass an empty Employee object to the form
        return "register";
    }

    // Handle registration form submission
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") AppUser user, Model model) {
        try{
            appUserService.saveUser(user);
            model.addAttribute("success", "Registration Successful");
            return "redirect:/login";
        } catch (RuntimeException e) {
            model.addAttribute("error", "Email already in use");
            System.out.println("Error in saving user" + e.getMessage());
            return "register";
        }
    }



}
