package kr.gyuna.interview.user.application.port.in;

import kr.gyuna.interview.user.domain.UserId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserPasswordCommand {

    private UserId userId;
    private String oldPassword;
    private String newPassword;

    public UserId getUserId(){
        return this.userId;
    }

    public String getOldPassword(){
        return this.oldPassword;
    }

    public String getNewPassword(){
        return this.newPassword;
    }


}
