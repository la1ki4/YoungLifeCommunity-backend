package org.yl.auth.api.spring.webmvc.login;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yl.auth.api.login.AuthorizationYoungLifeUserApi;
import org.yl.auth.login.data.YoungLifeUserLoginRequestData;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
@CrossOrigin
public class AuthorizationYoungLifeUserController {
    private final AuthorizationYoungLifeUserApi authorizationYoungLifeUserApi;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody YoungLifeUserLoginRequestData requestData) {
        String jwtToken = authorizationYoungLifeUserApi.generateTokenForYoungLifeUser(requestData.getEmail(),
                requestData.getPassword());
        ResponseCookie cookie = ResponseCookie.from("jwt", jwtToken)
                .httpOnly(true)
                .secure(false)
                .path("/")
                .maxAge(24*60*60)
                .build();
        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(Map.of("token", jwtToken));
    }
}
