package kr.gyuna.interview.user.application.port.in;

import kr.gyuna.interview.user.domain.UserId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeleteUserCommand {

    private UserId userId;

    public UserId getUserId(){
        return this.userId;
    }
}
