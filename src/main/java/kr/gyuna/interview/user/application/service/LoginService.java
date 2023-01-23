package kr.gyuna.interview.user.application.service;

import jakarta.transaction.Transactional;
import kr.gyuna.interview.common.response.DefaultResponse;
import kr.gyuna.interview.common.security.jwt.JwtTokenUtil;
import kr.gyuna.interview.user.adapter.in.web.response.TokenRes;
import kr.gyuna.interview.user.application.port.in.LoginCommand;
import kr.gyuna.interview.user.application.port.in.LoginUseCase;
import kr.gyuna.interview.user.application.port.out.FindUserPort;
import kr.gyuna.interview.user.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Slf4j
@Transactional
@Service
@RequiredArgsConstructor
public class LoginService implements LoginUseCase {

    private final FindUserPort findUserPort;
    private final JwtTokenUtil jwtTokenUtil;

    @Override
    public DefaultResponse login(LoginCommand command) {

        User user = findUserPort.findByUserMail(command.getUserMail());
        user.verifyPassword(command.getUserPassword());

        log.info("command.getUserMail: " + command.getUserMail());
        log.info("user.getUserId.showId: " + user.getUserId().showId());

        String token = jwtTokenUtil.generateToken(
                command.getUserMail(),
                user.getUserId().showId()
        );

        log.info("LoginService.login4");
        TokenRes tokenRes = TokenRes.builder()
                .token(token)
                .build();

        log.info("token: " + token);

        return new DefaultResponse(
                HttpStatus.OK.value(),
                "토큰 발급이 완료되었습니다.",
                tokenRes
        );
    }
}
