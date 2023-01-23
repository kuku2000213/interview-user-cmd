package kr.gyuna.interview.user.application.port.in;

import kr.gyuna.interview.common.response.DefaultResponse;

public interface DeleteUserUseCase {

    DefaultResponse deleteUserById(DeleteUserCommand command);
}
