package com.CapstoneApp.TitanFit.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.time.DayOfWeek;

@Entity
@Data
@Table(name = "workout_days")
public class WorkoutDay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DayOfWeek dayOfWeek;

    @ManyToMany
    @JoinTable(
            name = "workoutday_workouts",
            joinColumns = @JoinColumn(name = "workout_day_id"),
            inverseJoinColumns = @JoinColumn(name = "workout_id")
    )
    private List<Workout> workouts = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "workout_plan_id")
    private WorkoutPlan workoutPlan;
}

