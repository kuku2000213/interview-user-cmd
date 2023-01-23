package kr.gyuna.interview.user.adapter.in.web;

import kr.gyuna.interview.common.response.DefaultResponse;
import kr.gyuna.interview.user.application.port.in.DeleteUserCommand;
import kr.gyuna.interview.user.application.port.in.DeleteUserUseCase;
import kr.gyuna.interview.user.domain.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DeleteUserController {

    private final DeleteUserUseCase deleteUserUseCase;

    @DeleteMapping("/v1/users/{id}")
    public ResponseEntity<DefaultResponse> deleteUser(
            @PathVariable(name = "id") String userId
    ){
        DeleteUserCommand command = DeleteUserCommand.builder()
                .userId(UserId.of(userId))
                .build();

        DefaultResponse response = deleteUserUseCase.deleteUserById(command);

        return new ResponseEntity<>(
                response,
                HttpStatus.OK
        );
    }

}
