package kr.gyuna.interview.user.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import kr.gyuna.interview.user.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static kr.gyuna.interview.user.domain.QUser.user;

@Transactional
@Repository
public class UserDSL {
    private final JPAQueryFactory jpaQueryFactory;

    public UserDSL(
        EntityManager entityManager
    ){
        this.jpaQueryFactory = new JPAQueryFactory(entityManager);
    }


    public Optional<User> findByUserMail(String userMail) {
        return Optional.ofNullable(jpaQueryFactory.selectFrom(user)
                .where(user.userAccount.userMail.eq(userMail))
                .fetchOne()
        );
    }
}
