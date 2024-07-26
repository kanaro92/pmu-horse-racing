package fr.pmu.pmu_horse_racing.configuration;

import fr.pmu.pmu_horse_racing.constant.AppConstant;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic courseTopic() {
        return TopicBuilder.name(AppConstant.COURSE_TOPIC).build();
    }
}

