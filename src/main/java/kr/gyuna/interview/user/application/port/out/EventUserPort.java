package kr.gyuna.interview.user.application.port.out;

import com.fasterxml.jackson.core.JsonProcessingException;
import kr.gyuna.interview.user.domain.User;

public interface EventUserPort {

    void publishNewUser(User user) throws JsonProcessingException;
}
