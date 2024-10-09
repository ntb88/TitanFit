//package com.CapstoneApp.TitanFit.Model;
//
//import jakarta.persistence.*;
//import lombok.Data;
//import java.util.List;
//import java.time.DayOfWeek;
//
//@Entity
//@Data
//@Table(name = "workout_days")
//public class WorkoutDay {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Enumerated(EnumType.STRING)
//    @Column(nullable = false)
//    private DayOfWeek dayOfWeek;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "workout_plan_id")
//    private WorkoutPlan workoutPlan;
//
//    @OneToMany(mappedBy = "workoutDay", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Workout> workouts;
//}
//
