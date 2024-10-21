package com.CapstoneApp.TitanFit.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/admin")
public class AdminController {

//    // User Management Page
    @GetMapping
    public String adminPage(Model model) {
        return "adminpage";
    }
}

