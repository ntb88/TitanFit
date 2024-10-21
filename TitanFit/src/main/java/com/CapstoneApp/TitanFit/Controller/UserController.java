package com.CapstoneApp.TitanFit.Controller;


import com.CapstoneApp.TitanFit.Model.AppUser;
import com.CapstoneApp.TitanFit.Model.WorkoutPlan;
import com.CapstoneApp.TitanFit.Service.AppUserService;
import com.CapstoneApp.TitanFit.Service.WorkoutPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private WorkoutPlanService workoutPlanService;

    @Autowired
    private AppUserService appUserService;


    @GetMapping
    public String userPage(Model model) {

        AppUser currentUser = appUserService.getCurrentUser();
        List<WorkoutPlan> selectedWorkoutPlans = workoutPlanService.getWorkoutPlansByUser(currentUser);
        model.addAttribute("selectedWorkoutPlans", selectedWorkoutPlans);
        return "userspage";  // Thymeleaf template: userpage.html
    }

    @GetMapping("/selectWorkoutPlan")
    public String selectWorkoutPlan(Model model) {
        List<WorkoutPlan> workoutPlans = workoutPlanService.getAllWorkoutPlans();
        model.addAttribute("workoutPlans", workoutPlans);
        return "selectWorkoutPlan";
    }

    @PostMapping("/selectedWorkoutPlan")
    public String selectWorkoutPlan(@RequestParam Long planId) {
        AppUser currentUser = appUserService.getCurrentUser();  // Fetch the current user
        WorkoutPlan selectedPlan = workoutPlanService.getWorkoutPlanById(planId);
        selectedPlan.setUser(currentUser);  // Assign the workout plan to the current user

        workoutPlanService.createWorkoutPlan(selectedPlan);  // Save the assignment
        return "redirect:/user";  // Redirect to the user page to reflect the change
    }


}

