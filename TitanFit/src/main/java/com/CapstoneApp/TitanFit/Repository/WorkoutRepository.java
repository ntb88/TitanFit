package com.CapstoneApp.TitanFit.Repository;

import com.CapstoneApp.TitanFit.Model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {

    List<Workout> findByCategory(String category);
}
