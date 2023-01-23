package kr.gyuna.interview.common.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Slf4j
@Component
public class JwtTokenUtil implements Serializable {

    private static final long SERIAL_VERSION_UID = -23123094812039482L;

    public static final long JWT_TOKEN_VALIDITY = 1000 * 60 * 60 * 24;

    // lombok import 하지 말 것
    @Value("${jwt.secret}")
    private String secret;


    public String generateToken(String userMail, String userId) {
        log.info("JwtTokenUtil1");
        Map<String, Object> claims = new HashMap<>();
        log.info("JwtTokenUtil2");
        claims.put("userId", userId);
        log.info("JwtTokenUtil3");

        String token = doGenerateToken(claims, userMail);
        log.info("JwtTokenUtil4");
//        return doGenerateToken(claims, userMail);
        return token;
    }

    private String doGenerateToken(Map<String, Object> claims, String subject) {
        log.info("JwtTokenUtil5");
        String token = Jwts
                .builder()
                .setClaims(claims)  // Token 에 담을 정보
                .setSubject(subject) // Token 제목
                .setIssuedAt(new Date(System.currentTimeMillis()))  // Token 발급 시간
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY)) // Token 만료 시간
                .signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encodeToString(secret.getBytes())) // 알고리즘, 비밀키
                .compact();

        log.info("JwtTokenUtil6");
        return token;
    }

}
