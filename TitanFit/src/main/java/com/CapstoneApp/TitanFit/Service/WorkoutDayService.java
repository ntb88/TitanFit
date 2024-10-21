package com.CapstoneApp.TitanFit.Service;

import com.CapstoneApp.TitanFit.Model.WorkoutDay;
import com.CapstoneApp.TitanFit.Repository.WorkoutDayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutDayService {

    @Autowired
    private WorkoutDayRepository workoutDayRepository;

    //You get all workoutdays available
    public List<WorkoutDay> getAllWorkoutDays(){
        return workoutDayRepository.findAll();
    }

    //get each workoutday by id so you can customize them
    public WorkoutDay getWorkoutDayById(int id){
        return workoutDayRepository.findById(id).get();
    }

    //save workout day after building them with custom workouts
    public WorkoutDay createWorkoutDay(WorkoutDay workoutDay){
        return workoutDayRepository.save(workoutDay);
    }

    //delete the workout day
    public void deleteWorkoutDay(WorkoutDay workoutDay){
        workoutDayRepository.delete(workoutDay);
    }

}
