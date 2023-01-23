package kr.gyuna.interview.user.adapter.in.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import kr.gyuna.interview.common.response.DefaultResponse;
import kr.gyuna.interview.user.adapter.in.web.request.CreateUserReq;
import kr.gyuna.interview.user.application.port.in.CreateUserCommand;
import kr.gyuna.interview.user.application.port.in.CreateUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CreateUserController {

    private final CreateUserUseCase createUserUseCase;

    @PostMapping("/v1/auth/users")
    public ResponseEntity<DefaultResponse> createUser(
            @RequestBody CreateUserReq createUserReq
    ) throws JsonProcessingException {
        CreateUserCommand command = CreateUserCommand.builder()
                .userMail(createUserReq.getMail())
                .userPassword(createUserReq.getPassword())
                .userAge(createUserReq.getAge())
                .userGender(createUserReq.getGender())
                .userName(createUserReq.getName())
                .userType(createUserReq.getType())
                .build();

        DefaultResponse response = createUserUseCase.createUser(command);

        return new ResponseEntity<>(
                response,
                HttpStatus.OK
        );
    }
}
