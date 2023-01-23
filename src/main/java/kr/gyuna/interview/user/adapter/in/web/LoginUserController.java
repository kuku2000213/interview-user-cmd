package kr.gyuna.interview.user.adapter.in.web;

import kr.gyuna.interview.common.response.DefaultResponse;
import kr.gyuna.interview.user.adapter.in.web.request.LoginReq;
import kr.gyuna.interview.user.application.port.in.LoginCommand;
import kr.gyuna.interview.user.application.port.in.LoginUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginUserController {

    private final LoginUseCase loginUseCase;

    @PostMapping("/v1/auth/login")
    public ResponseEntity<DefaultResponse> login(
            @RequestBody LoginReq loginReq
    ) {
        LoginCommand command = LoginCommand.builder()
                .userMail(loginReq.getMail())
                .userPassword(loginReq.getPassword())
                .build();

        DefaultResponse response = loginUseCase
                .login(command);

        return new ResponseEntity<>(
                response,
                HttpStatus.OK
        );
    }
}
