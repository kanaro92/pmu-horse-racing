package fr.pmu.pmu_horse_racing.service;

import fr.pmu.pmu_horse_racing.model.Course;
import fr.pmu.pmu_horse_racing.model.Partant;
import fr.pmu.pmu_horse_racing.repository.CourseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Transactional
    public Course createCourse(Course course) {

        if (course.getPartants().size() < 3) {
            throw new IllegalArgumentException("Une course doit au minimum posseder 3 partants");
        }

        // S'assurer que les partans son numerotes correctements
        int number = 1;
        for (Partant partant : course.getPartants()) {
            partant.setNumber(number++);
            partant.setCourse(course);
        }

        return courseRepository.save(course);
    }
}
