package fr.pmu.pmu_horse_racing.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Partant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;
}
