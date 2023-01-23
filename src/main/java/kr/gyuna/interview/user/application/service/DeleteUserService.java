package kr.gyuna.interview.user.application.service;

import jakarta.transaction.Transactional;
import kr.gyuna.interview.common.response.DefaultResponse;
import kr.gyuna.interview.user.application.port.in.DeleteUserCommand;
import kr.gyuna.interview.user.application.port.in.DeleteUserUseCase;
import kr.gyuna.interview.user.application.port.out.DeleteUserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Transactional
@Service
@RequiredArgsConstructor
public class DeleteUserService implements DeleteUserUseCase {

    private final DeleteUserPort deleteUserPort;

    @Override
    public DefaultResponse deleteUserById(DeleteUserCommand command) {

        deleteUserPort.deleteUserById(command.getUserId());

        return new DefaultResponse(
                HttpStatus.OK.value(),
                "회원이 정상적으로 삭제되었습니다.",
                command.getUserId().showId()
        );
    }
}
