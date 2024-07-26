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
    private String nom;
    private String date;
    @Column(unique = true)
    private int numero;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Partant> partants;
}
