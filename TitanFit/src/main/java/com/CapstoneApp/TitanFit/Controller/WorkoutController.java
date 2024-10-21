package com.CapstoneApp.TitanFit.Controller;


import com.CapstoneApp.TitanFit.Model.AppUser;
import com.CapstoneApp.TitanFit.Model.Workout;
import com.CapstoneApp.TitanFit.Service.WorkoutService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/admin/workouts")
public class WorkoutController {

    @Autowired
    private WorkoutService workoutService;

    // view all workouts
    @GetMapping
    public String viewWorkouts(Model model) {
        List<Workout> workouts = workoutService.getAllWorkouts();
        model.addAttribute("workouts", workouts);
        return "workouts";
    }

    @GetMapping("/add")
    public String showAddWorkoutForm(Model model){
        model.addAttribute("workout", new Workout());
        model.addAttribute("action", "Add");
        return "addEditWorkoutForm";
    }

    @GetMapping("/edit/{id}")
    public String showEditWorkoutForm(@PathVariable("id") Long id, Model model){
        Workout workout = workoutService.getWorkoutById(id);
        model.addAttribute("action", "Edit");
        model.addAttribute("workout", workout);
        return "addEditWorkoutForm";
    }


    //save user and redirect
    @PostMapping("/save")
    public String saveWorkout(@Valid @ModelAttribute("workout") Workout workout, Model model, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            if(workout.getWorkoutId() == null){
                model.addAttribute("action", "Add");
            } else {
                model.addAttribute("action", "Edit");
            }
            return "addEditWorkoutForm";
        }
        if(workout.getWorkoutId() == null){
            workoutService.addWorkout(workout);
        } else {
            workoutService.updateWorkout(workout.getWorkoutId(), workout);
        }
        return "redirect:/admin/workouts";
    }

    // delete user
    @PostMapping("/delete/{id}")
    public String deleteWorkout(@PathVariable("id") Long id){
        workoutService.deleteWorkout(id);
        return "redirect:/admin/workouts";
    }



}
