package kr.gyuna.interview.user.adapter.in.web.request;

import lombok.Getter;

@Getter
public class UpdateUserPasswordReq {
    private String oldPassword;
    private String newPassword;
}
