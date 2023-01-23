package kr.gyuna.interview.user.adapter.out.persistence;

import kr.gyuna.interview.user.application.port.out.CreateUserPort;
import kr.gyuna.interview.user.application.port.out.DeleteUserPort;
import kr.gyuna.interview.user.application.port.out.FindUserPort;
import kr.gyuna.interview.user.domain.User;
import kr.gyuna.interview.user.domain.UserId;
import kr.gyuna.interview.user.repository.UserDSL;
import kr.gyuna.interview.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class UserPersistenceAdapter implements
        CreateUserPort,
        DeleteUserPort,
        FindUserPort{

    private final UserRepository userRepository;
    private final UserDSL userDSL;

    @Override
    public UserId createUser(User user) {

        User createdUser = userRepository.save(user);

        return createdUser.getUserId();
    }

    @Override
    public void deleteUserById(UserId userId) {

        Optional<User> userOpt = userRepository.findById(userId);

        userOpt.orElseThrow(() -> new NullPointerException("해당 사용자가 존재하지 않습니다. >> " + userId.showId()));

        userRepository.deleteById(userId);
    }

    @Override
    public User findUserById(UserId userId) {

        Optional<User> userOpt = userRepository.findById(userId);

        return userOpt.orElseThrow(() ->
                new NullPointerException("해당 사용자가 존재하지 않습니다. >> " + userId.showId()));
    }

    @Override
    public User findByUserMail(String userMail) {

        Optional<User> userOpt = userDSL.findByUserMail(userMail);

        return userOpt.orElseThrow(() -> (
            new NullPointerException("해당 사용자가 존재하지 않습니다. >> " + userMail)
        ));
    }
}
