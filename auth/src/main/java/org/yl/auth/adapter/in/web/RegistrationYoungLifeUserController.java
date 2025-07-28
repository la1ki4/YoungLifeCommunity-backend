package org.yl.auth.adapter.in.web;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.yl.auth.core.model.YoungLifeUserModel;
import org.yl.auth.core.port.in.RegistrationYoungLifeUserUseCase;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class RegistrationYoungLifeUserController {
    private final RegistrationYoungLifeUserUseCase registrationYoungLifeUseCase;

    @PostMapping("/register")
    public String register(@RequestParam String email,
                           @RequestParam String password,
                           @RequestParam String firstName,
                           @RequestParam String lastName) {
        YoungLifeUserModel youngLifeUserModel = registrationYoungLifeUseCase.registerYoungLifeUser(email, password, firstName, lastName);
        return youngLifeUserModel == null ? "User is already registered" : "Successful registration";
    }
}
