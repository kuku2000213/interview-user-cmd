package kr.gyuna.interview.user.adapter.out.event;

import kr.gyuna.interview.user.domain.UserType;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class NewUserEvent {

    private String userId;
    private UserType userType;
    private UserState userState;
}
