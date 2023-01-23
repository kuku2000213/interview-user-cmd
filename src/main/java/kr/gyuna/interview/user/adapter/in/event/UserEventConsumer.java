package kr.gyuna.interview.user.adapter.in.event;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserEventConsumer {

    @KafkaListener(topics = "${kafka.topics.user-status}", groupId = "${kafka.consumer.group-id}")
    void listen(String message) {
        log.info("Consumer.listen: " + message);
    }
}