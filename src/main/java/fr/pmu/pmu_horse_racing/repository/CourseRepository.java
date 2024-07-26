package fr.pmu.pmu_horse_racing.repository;

import fr.pmu.pmu_horse_racing.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
