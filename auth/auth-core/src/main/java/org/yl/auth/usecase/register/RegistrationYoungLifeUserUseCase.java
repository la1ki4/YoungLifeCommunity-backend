package org.yl.auth.usecase.register;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.yl.auth.api.register.RegistrationYoungLifeUserApi;
import org.yl.auth.model.YoungLifeUserModel;
import org.yl.auth.spi.register.RegistrationYoungLifeUserSpi;
import org.yl.auth.spi.login.YoungLifeUserAuthorizationSpi;

import java.sql.Timestamp;

public record RegistrationYoungLifeUserUseCase(YoungLifeUserAuthorizationSpi userRepository,
                                               RegistrationYoungLifeUserSpi registerUserPort,
                                               PasswordEncoder passwordEncoder) implements RegistrationYoungLifeUserApi {
    @Override
    public YoungLifeUserModel registerYoungLifeUser(String email, String password, String firstName, String lastName) {
        YoungLifeUserModel youngLifeUserModel = userRepository.getUserByEmail(email);
        if (youngLifeUserModel == null) {
            youngLifeUserModel = registerUserPort.registerYoungLifeUser(
                    YoungLifeUserModel.builder()
                            .email(email)
                            .firstName(firstName)
                            .lastName(lastName)
                            .password(passwordEncoder.encode(password))
                            .createdAt(new Timestamp(System.currentTimeMillis()))
                            .build()
            );
            return youngLifeUserModel;
        }
        return null;
    }
}
