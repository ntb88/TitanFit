package com.CapstoneApp.TitanFit.Controller;

import java.time.DayOfWeek;
import com.CapstoneApp.TitanFit.Model.WorkoutDay;
import com.CapstoneApp.TitanFit.Model.WorkoutPlan;
import com.CapstoneApp.TitanFit.Service.AppUserService;
import com.CapstoneApp.TitanFit.Service.WorkoutDayService;
import com.CapstoneApp.TitanFit.Service.WorkoutPlanService;
import com.CapstoneApp.TitanFit.Service.WorkoutService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin/plans")
public class WorkoutPlanController {

    @Autowired
    private WorkoutPlanService workoutPlanService;

    @Autowired
    private WorkoutService workoutService;

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private WorkoutDayService workoutDayService;


    //Get all the workout plans
    @GetMapping
    public String viewWorkoutPlans(Model model) {
        model.addAttribute("workoutPlans", workoutPlanService.getAllWorkoutPlans());
        return "workoutPlans";
    }

    //show form to create workout plan
    @GetMapping("/add")
    public String addWorkoutPlan(Model model) {
        WorkoutPlan workoutPlan = new WorkoutPlan();

        //list Workout days for each day of the week
        List<WorkoutDay> workoutDays = new ArrayList<>();
        for (DayOfWeek day : DayOfWeek.values()) {
            WorkoutDay workoutDay = new WorkoutDay();
            workoutDay.setDayOfWeek(day);
            workoutDay.setWorkoutPlan(workoutPlan);
            workoutDays.add(workoutDay);
        }

        workoutPlan.setWorkoutDays(workoutDays);
        model.addAttribute("workoutPlan", workoutPlan);
        model.addAttribute("workouts", workoutService.getAllWorkouts());
        model.addAttribute("users", appUserService.getAllUsers());
        model.addAttribute("action", "Add");
        return "addorEditWorkoutPlan";
    }
    @PostMapping("/save")
    public String saveWorkoutPlan(@Valid @ModelAttribute("workoutPlan") WorkoutPlan workoutPlan,
                                  BindingResult bindingResult,
                                  Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("action", workoutPlan.getId() == 0 ? "Add" : "Edit");
            model.addAttribute("workouts", workoutService.getAllWorkouts());
            model.addAttribute("users", appUserService.getAllUsers());
            return "addorEditWorkoutPlan";
        }
        workoutPlanService.createWorkoutPlan(workoutPlan); // Make sure to implement this service method
        return "redirect:/admin/plans"; // Redirect to the list of workout plans after saving
    }



}
