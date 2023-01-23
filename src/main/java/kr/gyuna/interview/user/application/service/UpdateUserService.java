package kr.gyuna.interview.user.application.service;

import jakarta.transaction.Transactional;
import kr.gyuna.interview.common.response.DefaultResponse;
import kr.gyuna.interview.user.application.port.in.UpdateUserPasswordCommand;
import kr.gyuna.interview.user.application.port.in.UpdateUserPersonalCommand;
import kr.gyuna.interview.user.application.port.in.UpdateUserUseCase;
import kr.gyuna.interview.user.application.port.out.FindUserPort;
import kr.gyuna.interview.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class UpdateUserService implements UpdateUserUseCase {

    private final FindUserPort findUserPort;

    @Override
    public DefaultResponse updateUserPersonal(UpdateUserPersonalCommand command) {

        User user = findUserPort.findUserById(command.getUserId());

        user.updateUserPersonal(
                command.toValue()
        );

        return new DefaultResponse(
                HttpStatus.OK.value(),
                "회원정보가 정상적으로 변경되었습니다.",
                command.getUserId().showId()
        );
    }

    @Override
    public DefaultResponse updateUserPassword(UpdateUserPasswordCommand command) {
        User user = findUserPort.findUserById(command.getUserId());

        user.changePassword(
                command.getOldPassword(),
                command.getNewPassword()
        );

        return new DefaultResponse(
                HttpStatus.OK.value(),
                "비밀번호가 정상적으로 변경되었습니다.",
                command.getUserId().showId()
        );
    }
}
