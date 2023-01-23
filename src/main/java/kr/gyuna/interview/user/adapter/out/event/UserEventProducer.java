package kr.gyuna.interview.user.adapter.out.event;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.gyuna.interview.user.application.port.out.EventUserPort;
import kr.gyuna.interview.user.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserEventProducer implements EventUserPort {

    @Value("${kafka.topics.user-status}")
    private String topic;

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final KafkaTemplate<String, String> kafkaTemplate;

    public UserEventProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishNewUser(User user) throws JsonProcessingException {
        NewUserEvent newUserEvent = NewUserEvent.builder()
                .userId(user.getUserId().showId())
                .userType(user.getUserType())
                .userState(UserState.ACTIVATED)
                .build();

        String message = objectMapper.writeValueAsString(newUserEvent);

        log.info("topic: " + topic);
        log.info("message: " + message);
        kafkaTemplate.send(this.topic, message);
    }
}