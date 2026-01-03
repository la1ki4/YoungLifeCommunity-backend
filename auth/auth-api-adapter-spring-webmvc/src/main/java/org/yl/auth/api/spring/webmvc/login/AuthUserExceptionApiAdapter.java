package org.yl.auth.api.spring.webmvc.login;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.yl.auth.api.login.AuthUserExceptionsApi;
import org.yl.auth.login.data.YoungLifeUserLoginRequestData;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthUserExceptionApiAdapter {
    private final AuthUserExceptionsApi authUserExceptionsApi;

    @PostMapping("/exception")
    public Optional<List<String>> getAuthUserExceptionApi(@RequestBody YoungLifeUserLoginRequestData loginRequestData) {
        return authUserExceptionsApi.authorizationException(
                loginRequestData.getEmail(),
                loginRequestData.getPassword()
        );
    }
}
