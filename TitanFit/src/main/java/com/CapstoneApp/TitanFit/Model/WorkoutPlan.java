//package com.CapstoneApp.TitanFit.Model;
//
//
//import jakarta.persistence.*;
//import lombok.Data;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Entity
//@Data
//@Table(name = "workout_plans")
//public class WorkoutPlan {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private int id;
//
//    @Column(unique = true, nullable = false)
//    private String name;
//
//    @Column(length = 500)
//    private String description;
//
//    private String planURL;
//
//    @Column(nullable = false, updatable = false)
//    private LocalDateTime createdAt = LocalDateTime.now();
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private User user;
//
//    @OneToMany(mappedBy = "workoutPlan", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<WorkoutDay> workoutDays;
//}
