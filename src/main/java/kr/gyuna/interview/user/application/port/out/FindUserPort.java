package kr.gyuna.interview.user.application.port.out;


import kr.gyuna.interview.user.domain.User;
import kr.gyuna.interview.user.domain.UserId;

public interface FindUserPort {

    User findUserById(UserId userId);
    User findByUserMail(String userMail);
}
