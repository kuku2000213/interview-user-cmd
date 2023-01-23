package kr.gyuna.interview.user.adapter.in.web;

import kr.gyuna.interview.common.response.DefaultResponse;
import kr.gyuna.interview.user.adapter.in.web.request.UpdateUserPasswordReq;
import kr.gyuna.interview.user.adapter.in.web.request.UpdateUserPersonalReq;
import kr.gyuna.interview.user.application.port.in.UpdateUserPasswordCommand;
import kr.gyuna.interview.user.application.port.in.UpdateUserPersonalCommand;
import kr.gyuna.interview.user.application.port.in.UpdateUserUseCase;
import kr.gyuna.interview.user.domain.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UpdateUserController {

    private final UpdateUserUseCase updateUserUseCase;

    @PutMapping("/v1/users/{id}/personal")
    public ResponseEntity<DefaultResponse> updateUserPersonal(
            @RequestBody UpdateUserPersonalReq updateUserPersonalReq,
            @PathVariable(name = "id") String id
    ) {
        UpdateUserPersonalCommand command = UpdateUserPersonalCommand.builder()
                .userId(UserId.of(id))
                .userName(updateUserPersonalReq.getName())
                .userAge(updateUserPersonalReq.getAge())
                .userGender(updateUserPersonalReq.getGender())
                .build();

        DefaultResponse response = updateUserUseCase.updateUserPersonal(command);

        return new ResponseEntity<>(
                response,
                HttpStatus.OK
        );
    }

    @PutMapping("/v1/users/{id}/password")
    public ResponseEntity<DefaultResponse> updateUserPassword(
            @RequestBody UpdateUserPasswordReq req,
            @PathVariable(name = "id") String userId
    ) {
        UpdateUserPasswordCommand command = UpdateUserPasswordCommand.builder()
                .userId(UserId.of(userId))
                .oldPassword(req.getOldPassword())
                .newPassword(req.getNewPassword())
                .build();

        DefaultResponse response = updateUserUseCase.updateUserPassword(command);

        return new ResponseEntity<>(
                response,
                HttpStatus.OK
        );
    }
}
