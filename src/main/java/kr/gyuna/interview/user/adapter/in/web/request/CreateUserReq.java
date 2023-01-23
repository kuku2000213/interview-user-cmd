package kr.gyuna.interview.user.adapter.in.web.request;

import kr.gyuna.interview.user.domain.UserGender;
import kr.gyuna.interview.user.domain.UserType;
import lombok.Getter;

@Getter
public class CreateUserReq {
    private String mail;
    private String password;
    private int age;
    private UserGender gender;
    private String name;
    private UserType type;

}