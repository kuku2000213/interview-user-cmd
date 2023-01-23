package kr.gyuna.interview.user.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class UserPersonal {

    private String userName;
    private int userAge;
    @Enumerated(value = EnumType.STRING)
    private UserGender userGender;

}
