package kr.gyuna.interview.user.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;



@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @EmbeddedId
    private UserId userId;

    @Enumerated(value = EnumType.STRING)
    private UserType userType;

    @Embedded
    private UserAccount userAccount;

    @Embedded
    private UserPersonal userPersonal;

    public void encodePassword(){
        this.userAccount.encodePassword();
    }

    public void updateUserPersonal(
            UserPersonal userPersonal
    ){
        this.userPersonal = userPersonal;
    }

    public void changePassword(
        String oldPassword,
        String newPassword
    ){
        this.userAccount.changePassword(
                oldPassword,
                newPassword
        );
    }

    public void recordCreatedDate(){
        this.userAccount.recordCreatedDate();
    }

    public void verifyPassword(
            String password
    ){
        this.userAccount.verifyPassword(password);
    }
}
