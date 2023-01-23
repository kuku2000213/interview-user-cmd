package kr.gyuna.interview.user.application.port.out;

import kr.gyuna.interview.user.domain.User;
import kr.gyuna.interview.user.domain.UserId;

public interface CreateUserPort {

    UserId createUser(User user);
}
