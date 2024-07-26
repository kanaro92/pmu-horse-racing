package fr.pmu.pmu_horse_racing;

import fr.pmu.pmu_horse_racing.constant.AppConstant;
import fr.pmu.pmu_horse_racing.model.Course;
import fr.pmu.pmu_horse_racing.model.Partant;
import fr.pmu.pmu_horse_racing.publisher.CoursePublisher;
import fr.pmu.pmu_horse_racing.repository.CourseRepository;
import fr.pmu.pmu_horse_racing.service.CourseService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class PmuHorseRacingApplicationTests {

	@Mock
	private CourseRepository courseRepository;
	@Mock
	private CoursePublisher coursePublisher;
	@Mock
	private KafkaTemplate<String, Course> kafkaTemplate;

	@InjectMocks
	private CourseService courseService;

	@Test
	public void testCreateCourse() {
		Course course = new Course();
		course.setNom("Test Course");
		course.setDate("2023-07-26");
		course.setNumero(1);

		Partant partant1 = new Partant();
		partant1.setNom("Horse 1");
		Partant partant2 = new Partant();
		partant2.setNom("Horse 2");
		Partant partant3 = new Partant();
		partant3.setNom("Horse 3");

		course.setPartants(Arrays.asList(partant1, partant2, partant3));

		when(courseRepository.save(any(Course.class))).thenReturn(course);
		//verify(coursePublisher, times(1)).publish(course);
		//verify(kafkaTemplate, times(1)).send(AppConstant.COURSE_TOPIC, course);

		Course createdCourse = courseService.createCourse(course);
		assertNotNull(createdCourse);
		assertEquals(3, createdCourse.getPartants().size());
	}

}
