package kr.gyuna.interview.user.repository;

import kr.gyuna.interview.user.domain.User;
import kr.gyuna.interview.user.domain.UserId;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, UserId> {
}
