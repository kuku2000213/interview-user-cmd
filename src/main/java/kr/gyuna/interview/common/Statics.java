package kr.gyuna.interview.common;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



public class Statics {
    public static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
}
