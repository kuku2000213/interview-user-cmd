package kr.gyuna.interview.user.adapter.in.web.request;

import kr.gyuna.interview.user.domain.UserGender;
import lombok.Getter;

@Getter
public class UpdateUserPersonalReq {

    private int age;
    private UserGender gender;
    private String name;
}
