package fr.pmu.pmu_horse_racing.repository;

import fr.pmu.pmu_horse_racing.model.Partant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartantRepository extends JpaRepository<Partant, Long> {
}
