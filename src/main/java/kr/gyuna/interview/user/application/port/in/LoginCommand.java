package kr.gyuna.interview.user.application.port.in;

import kr.gyuna.interview.user.domain.UserAccount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginCommand {

    private String userMail;
    private String userPassword;
}
