package kr.gyuna.interview.user.application.port.in;

import kr.gyuna.interview.user.domain.UserGender;
import kr.gyuna.interview.user.domain.UserId;
import kr.gyuna.interview.user.domain.UserPersonal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserPersonalCommand {

    private UserId userId;

    private int userAge;
    private UserGender userGender;
    private String userName;

    public UserId getUserId(){
        return this.userId;
    }

    public UserPersonal toValue(){
        return UserPersonal.builder()
                .userAge(this.userAge)
                .userGender(this.userGender)
                .userName(this.userName)
                .build();
    }
}
