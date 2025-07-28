package org.yl.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.yl.auth.core.port.in.AuthorizationYoungLifeUserUseCase;
import org.yl.auth.core.port.in.RegistrationYoungLifeUserUseCase;
import org.yl.auth.core.port.out.AuthenticateYoungLifeUserPort;
import org.yl.auth.core.port.out.RegistrationYoungLifeUserPort;
import org.yl.auth.core.service.AuthorizationYoungLifeUserService;
import org.yl.auth.core.service.RegistrationYoungLifeUserService;

@SpringBootApplication
public class YoungLifeCommunityAuthorization {
    public static void main(String[] args) {
        SpringApplication.run(YoungLifeCommunityAuthorization.class, args);
    }

    @Bean
    public AuthorizationYoungLifeUserUseCase authorizationYoungLifeUserUseCase(AuthenticateYoungLifeUserPort authenticateYoungLifeUserPort, PasswordEncoder encoder) {
        return new AuthorizationYoungLifeUserService(authenticateYoungLifeUserPort, encoder);
    }

    @Bean
    public RegistrationYoungLifeUserUseCase registrationYoungLifeUserUseCase(AuthenticateYoungLifeUserPort authenticateYoungLifeUserPort,
                                                                             RegistrationYoungLifeUserPort registrationYoungLifeUserPort,
                                                                             PasswordEncoder encoder) {
        return new RegistrationYoungLifeUserService(authenticateYoungLifeUserPort, registrationYoungLifeUserPort ,encoder);
    }
}
