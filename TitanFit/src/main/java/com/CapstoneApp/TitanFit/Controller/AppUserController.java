package com.CapstoneApp.TitanFit.Controller;

import com.CapstoneApp.TitanFit.Model.AppUser;
import com.CapstoneApp.TitanFit.Service.AppUserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/users/")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    //Admin only
    @GetMapping
    public String viewUsers(Model model){
        List<AppUser> users = appUserService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    //Admin only
    @GetMapping("/new")
    public String showCreateUsersForm(Model model){
        List<AppUser> users = appUserService.getAllUsers();
        model.addAttribute("users", users);
        return "create-users-form";
    }

    //Admin save new user
    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") AppUser user){
        appUserService.saveUser(user);
        return "redirect:/users";
    }

    // admin for edit/update existing user
    @GetMapping("/edit/{id}")
    public String showEditUserForm(Model model, @PathVariable Long id){
        AppUser editedUser = appUserService.getUserById(id);
        model.addAttribute("editedUser", editedUser);
        return "edit-user-form";
    }

    //Delete an existing user
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id){
        appUserService.deleteUser(id);
        return "redirect:/users";
    }





}
