package fr.pmu.pmu_horse_racing.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String date;
    private int number;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Partant> partants;
}
