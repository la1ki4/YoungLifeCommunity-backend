package org.yl.auth.api.spring.webmvc.login;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.yl.auth.api.login.AuthorizationYoungLifeUserApi;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthorizationYoungLifeUserController {
    private final AuthorizationYoungLifeUserApi authorizationYoungLifeUserApi;

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {
        return authorizationYoungLifeUserApi.generateTokenForYoungLifeUser(email, password);
    }
}
