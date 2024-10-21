package com.CapstoneApp.TitanFit.Controller;

import com.CapstoneApp.TitanFit.Model.AppUser;
import com.CapstoneApp.TitanFit.Service.AppUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/usermanagement")
public class UserManagementController {

    @Autowired
    public AppUserService appUserService;

    //Admin only view all users
    @GetMapping
    public String viewUsers(Model model){
        List<AppUser> users = appUserService.getAllUsers();
        model.addAttribute("users", users);
        return "usermanagement";
    }

    @GetMapping("/add")
    public String showAddUserForm(Model model){
        model.addAttribute("user", new AppUser());
        model.addAttribute("action", "Add");
        return "addEditUserForm";
    }

    @GetMapping("/edit/{id}")
    public String showEditUserForm(@PathVariable("id") Long id, Model model){
        AppUser user = appUserService.getUserById(id);
        model.addAttribute("action", "Edit");
        model.addAttribute("user", user);
        return "addEditUserForm";
    }

    //save user and redirect
    @PostMapping("/save")
    public String saveUser(@Valid @ModelAttribute("user") AppUser user, Model model, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            if(user.getId() == null){
                model.addAttribute("action", "Add");
            } else {
                model.addAttribute("action", "Edit");
            }
            return "addEditUserForm";
        }
        if(user.getId() == null){
            appUserService.saveUser(user);
        } else {
            appUserService.updateUser(user.getId(), user);
        }
        return "redirect:/admin/usermanagement";
    }

    // delete user
    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        appUserService.deleteUser(id);
        return "redirect:/admin/usermanagement";
    }



}
