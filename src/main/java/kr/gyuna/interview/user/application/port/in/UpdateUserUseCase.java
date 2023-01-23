package kr.gyuna.interview.user.application.port.in;

import kr.gyuna.interview.common.response.DefaultResponse;

public interface UpdateUserUseCase {

    DefaultResponse updateUserPersonal(UpdateUserPersonalCommand command);

    DefaultResponse updateUserPassword(UpdateUserPasswordCommand command);
}
