package com.CapstoneApp.TitanFit.Repository;

import com.CapstoneApp.TitanFit.Model.AppUser;
import com.CapstoneApp.TitanFit.Model.Workout;
import com.CapstoneApp.TitanFit.Model.WorkoutPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkoutPlanRepository extends JpaRepository<WorkoutPlan, Long> {
    List<WorkoutPlan> findByUser(AppUser user);
    List<WorkoutPlan> findByUserIsNull(); // Already created workout plan for all users

}
