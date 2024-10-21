package com.CapstoneApp.TitanFit.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "workouts")
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long workoutId;

    @Column(nullable = false)
    private String workoutName;

    @Column(nullable = false)
    private String workoutUrl; // YouTube link

    @Column(nullable = false)
    private String workoutDescription;

    @Column(nullable = false)
    private String category;

    private String reps; // Reps
}
