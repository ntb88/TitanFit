package com.CapstoneApp.TitanFit.Service;

import com.CapstoneApp.TitanFit.Model.AppUser;
import com.CapstoneApp.TitanFit.Model.Workout;
import com.CapstoneApp.TitanFit.Repository.WorkoutRepository;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutService {
    @Autowired
    private WorkoutRepository workoutRepository;

    //Get all workouts in a list
    public List<Workout> getAllWorkouts(){
        return workoutRepository.findAll();
    }

    //find workout by its id
    public Workout getWorkoutById(Long id){
        return workoutRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Workout not found"));
    }

    //save a new workout
    public Workout addWorkout(Workout workout){
        return workoutRepository.save(workout);
    }


    // update a workout
    public Workout updateWorkout(Long id, Workout workout){
        return workoutRepository.findById(id)
                .map(existingWorkout -> {
                    existingWorkout.setWorkoutDescription(workout.getWorkoutDescription());
                    existingWorkout.setWorkoutUrl(workout.getWorkoutUrl());
                    existingWorkout.setWorkoutName(workout.getWorkoutName());
                    existingWorkout.setCategory(workout.getCategory());
                    existingWorkout.setReps(workout.getReps());
                    return workoutRepository.save(existingWorkout);
                        })
                .orElseThrow(()-> new RuntimeException("Workout not found"));
    }

    // delete workouts
    public void deleteWorkout(Long id){
        workoutRepository.deleteById(id);
    }

    // filter by category
    public List<Workout> filterByCategory(String category){
        return workoutRepository.findByCategory(category);
    }



}
