package kr.gyuna.interview.user.application.port.in;

import com.fasterxml.jackson.core.JsonProcessingException;
import kr.gyuna.interview.common.response.DefaultResponse;

public interface CreateUserUseCase {
    DefaultResponse createUser(CreateUserCommand command) throws JsonProcessingException;
}
