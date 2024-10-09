package com.CapstoneApp.TitanFit.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/user")
public class UserController {

    @GetMapping("/")
    public String userPage() {
        return "userpage";  // Thymeleaf template: userpage.html
    }
}

