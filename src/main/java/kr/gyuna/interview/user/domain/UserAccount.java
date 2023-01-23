package kr.gyuna.interview.user.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


import java.util.Date;

import static kr.gyuna.interview.common.Statics.encoder;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class UserAccount {

    @Column(unique = true)
    private String userMail;
    private String userPassword;

    private Date userCreatedDate;

    protected void encodePassword(){

        this.userPassword = encoder.encode(this.userPassword);
    }

    protected void changePassword(
            String oldPassword,
            String newPassword
    ){
//        if(!encoder.matches(oldPassword, this.userPassword)){
//            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
//        }
        verifyPassword(oldPassword);

        this.userPassword = encoder.encode(newPassword);
    }

    protected void recordCreatedDate(){
        this.userCreatedDate = new Date();
    }

    protected void verifyPassword(String password){
        if(!encoder.matches(password, this.userPassword)){
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
    }
}
