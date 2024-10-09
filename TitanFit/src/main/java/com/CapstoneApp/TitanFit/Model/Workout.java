//package com.CapstoneApp.TitanFit.Model;
//
//import jakarta.persistence.*;
//import lombok.Data;
//
//@Entity
//@Data
//@Table(name = "workouts")
//public class Workout {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long workoutId;
//
//    @Column(nullable = false)
//    private String workoutName;
//
//    @Column(nullable = false)
//    private String workoutUrl; // YouTube link
//
//    @Column(nullable = false)
//    private String workoutDescription;
//
//    @Enumerated(EnumType.STRING)
//    @Column(nullable = false)
//    private WorkoutType workoutType;
//
//    @Column(nullable = false)
//    private Integer reps;
//
//    private Integer time; // Time in minutes or seconds
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "workout_day_id")
//    private WorkoutDay workoutDay;
//}
