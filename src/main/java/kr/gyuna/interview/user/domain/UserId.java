package kr.gyuna.interview.user.domain;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@NoArgsConstructor
@Embeddable
public class UserId implements Serializable {

    private String userUuid;

    public UserId(String userUuid) {
        if (userUuid == null) {
            throw new IllegalArgumentException("userUuid is null");
        }

        this.userUuid = userUuid;
    }


    @Override
    public int hashCode() {
        return Objects.hash(userUuid);
    }

    public static UserId of(String userUuid) {
        return new UserId(userUuid);
    }

    public static UserId uuid(){
        return new UserId(UUID.randomUUID().toString());
    }

    public String showId(){
        return this.userUuid;
    }
}
