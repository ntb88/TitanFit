package com.CapstoneApp.TitanFit.Service;

import com.CapstoneApp.TitanFit.Model.AppUser;
import com.CapstoneApp.TitanFit.Model.Workout;
import com.CapstoneApp.TitanFit.Model.WorkoutPlan;
import com.CapstoneApp.TitanFit.Repository.WorkoutPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutPlanService {

    @Autowired
    private WorkoutPlanRepository workoutPlanRepository;

    //List all workoutplans
    public List<WorkoutPlan> getAllWorkoutPlans() {
        return workoutPlanRepository.findAll();
    }

    //Get the workout plan
    public WorkoutPlan getWorkoutPlanById(Long id) {
        return workoutPlanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Workout Plan Not Found"));
    }

    //Save workout plan
    public WorkoutPlan createWorkoutPlan(WorkoutPlan plan) {
        if(plan.getWorkoutDays() != null){
            plan.getWorkoutDays().forEach(workoutDay -> {
                workoutDay.setWorkoutPlan(plan);
            });
        }
        return workoutPlanRepository.save(plan);
    }

    // update the existing workout plan
//    public WorkoutPlan updateWorkoutPlan(Long id, WorkoutPlan workoutPlan) {
//        return workoutPlanRepository.findById(id)
//                .map(existingWorkoutPlan -> {
//                    existingWorkoutPlan.setName(workoutPlan.getName());
//                    existingWorkoutPlan.setWorkouts(workoutPlan.getWorkouts());
//                    existingWorkoutPlan.setDescription(workoutPlan.getDescription());
//                    existingWorkoutPlan.setUser(workoutPlan.getUser());
//                    existingWorkoutPlan.setCreatedAt(workoutPlan.getCreatedAt());
//                    return workoutPlanRepository.save(workoutPlan);
//                })
//                .orElseThrow(() -> new RuntimeException("Workout Plan Not Found"));
//    }

    // user specific workouts
    public List<WorkoutPlan> getWorkoutPlansByUser(AppUser user) {
        return workoutPlanRepository.findByUser(user);
    }

    // find workoutplans belong to ADMIN's that are not assigned to user

    // delete workout plan
    public void deleteWorkoutPlan(Long id) {
        workoutPlanRepository.deleteById(id);
    }

}
