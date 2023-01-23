package kr.gyuna.interview.user.application.port.in;

import kr.gyuna.interview.user.domain.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserCommand {

    private String userMail;
    private String userPassword;
    private int userAge;
    private UserGender userGender;
    private String userName;

    private UserType userType;

    public User toEntity(){
        UserAccount userAccount = UserAccount
                .builder()
                .userMail(this.userMail)
                .userPassword(this.userPassword)
                .build();

        UserPersonal userPersonal = UserPersonal
                .builder()
                .userAge(this.userAge)
                .userGender(this.userGender)
                .userName(this.userName)
                .build();

        return User.builder()
                .userId(UserId.uuid())
                .userType(this.userType)
                .userAccount(userAccount)
                .userPersonal(userPersonal)
                .build();
    }
}
