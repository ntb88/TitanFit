package com.CapstoneApp.TitanFit.Repository;

import com.CapstoneApp.TitanFit.Model.WorkoutDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface WorkoutDayRepository extends JpaRepository<WorkoutDay, Integer> {

}
