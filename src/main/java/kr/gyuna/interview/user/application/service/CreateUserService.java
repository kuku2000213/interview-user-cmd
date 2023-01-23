package kr.gyuna.interview.user.application.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import kr.gyuna.interview.common.response.DefaultResponse;
import kr.gyuna.interview.user.application.port.in.CreateUserCommand;
import kr.gyuna.interview.user.application.port.in.CreateUserUseCase;
import kr.gyuna.interview.user.application.port.out.CreateUserPort;
import kr.gyuna.interview.user.application.port.out.EventUserPort;
import kr.gyuna.interview.user.domain.User;
import kr.gyuna.interview.user.domain.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class CreateUserService implements CreateUserUseCase {

    private final CreateUserPort createUserPort;
    private final EventUserPort eventUserPort;

    @Transactional(readOnly=false)
    @Override
    public DefaultResponse createUser(CreateUserCommand command) throws JsonProcessingException {

        User user = command.toEntity();

        user.encodePassword();
        user.recordCreatedDate();

        UserId createdUserId = createUserPort.createUser(user);
        eventUserPort.publishNewUser(user);

        return new DefaultResponse(
                HttpStatus.CREATED.value(),
                "회원이 성공적으로 등록되었습니다.",
                createdUserId.showId()
        );
    }
}
