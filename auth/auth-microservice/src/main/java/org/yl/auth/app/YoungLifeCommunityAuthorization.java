package org.yl.auth.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.yl.auth.api.login.AuthorizationYoungLifeUserApi;
import org.yl.auth.api.register.RegistrationYoungLifeUserApi;
import org.yl.auth.spi.register.RegistrationYoungLifeUserSpi;
import org.yl.auth.spi.verifier.VerifyYoungLifeUserByEmailSpi;
import org.yl.auth.usecase.login.AuthorizationYoungLifeUserUseCase;
import org.yl.auth.usecase.register.RegistrationYoungLifeUserUseCase;

@SpringBootApplication(scanBasePackages = {"org.yl.auth"})
@EnableJpaRepositories(basePackages = "org.yl.auth.spring.jpa")
@EntityScan(basePackages = "org.yl.auth.spring.jpa")
public class YoungLifeCommunityAuthorization {
    public static void main(String[] args) {
        SpringApplication.run(YoungLifeCommunityAuthorization.class, args);
    }

    @Bean
    public AuthorizationYoungLifeUserApi authorizationYoungLifeUserApi(VerifyYoungLifeUserByEmailSpi verifyYoungLifeUserByEmailSpi, PasswordEncoder encoder) {
        return new AuthorizationYoungLifeUserUseCase(verifyYoungLifeUserByEmailSpi, encoder);
    }

    @Bean
    public RegistrationYoungLifeUserApi registrationYoungLifeUserApi(VerifyYoungLifeUserByEmailSpi verifyYoungLifeUserByEmailSpi,
                                                                     RegistrationYoungLifeUserSpi registrationYoungLifeUserSpi,
                                                                     PasswordEncoder encoder) {
        return new RegistrationYoungLifeUserUseCase(verifyYoungLifeUserByEmailSpi, registrationYoungLifeUserSpi ,encoder);
    }
}
