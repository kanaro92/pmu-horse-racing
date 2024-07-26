package fr.pmu.pmu_horse_racing.publisher;

import fr.pmu.pmu_horse_racing.constant.AppConstant;
import fr.pmu.pmu_horse_racing.model.Course;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CoursePublisher implements EventPublisher<Course> {

    private final KafkaTemplate<String, Course> kafkaTemplate;

    public CoursePublisher(KafkaTemplate<String, Course> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void publish(Course course) {
        kafkaTemplate.send(AppConstant.COURSE_TOPIC, course);
        log.info("*********** Course published: {} ", course);
    }
}
