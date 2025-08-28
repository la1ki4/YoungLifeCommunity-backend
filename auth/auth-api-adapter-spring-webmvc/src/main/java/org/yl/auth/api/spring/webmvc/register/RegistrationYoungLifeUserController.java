package org.yl.auth.api.spring.webmvc.register;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.yl.auth.api.register.RegistrationYoungLifeUserApi;
import org.yl.auth.model.YoungLifeUserModel;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
@CrossOrigin
public class RegistrationYoungLifeUserController {
    private final RegistrationYoungLifeUserApi registrationYoungLifeUserApi;

    @PostMapping("/register")
    public String register(@RequestParam String email,
                           @RequestParam String password,
                           @RequestParam String firstName,
                           @RequestParam String lastName) {
        YoungLifeUserModel youngLifeUserModel = registrationYoungLifeUserApi.registerYoungLifeUser(email, password, firstName, lastName);
        return youngLifeUserModel == null ? "User is already registered" : "Successful registration";
    }
}
