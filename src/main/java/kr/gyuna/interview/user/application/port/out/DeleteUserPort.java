package kr.gyuna.interview.user.application.port.out;

import kr.gyuna.interview.user.domain.UserId;

public interface DeleteUserPort {

    void deleteUserById(UserId userId);
}
