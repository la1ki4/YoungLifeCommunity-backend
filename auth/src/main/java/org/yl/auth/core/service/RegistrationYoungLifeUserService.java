package org.yl.auth.core.service;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.yl.auth.core.model.YoungLifeUserModel;
import org.yl.auth.core.port.in.RegistrationYoungLifeUserUseCase;
import org.yl.auth.core.port.out.AuthenticateYoungLifeUserPort;
import org.yl.auth.core.port.out.RegistrationYoungLifeUserPort;

import java.sql.Timestamp;

@AllArgsConstructor
public class RegistrationYoungLifeUserService implements RegistrationYoungLifeUserUseCase {
    private final AuthenticateYoungLifeUserPort findUserPort;
    private final RegistrationYoungLifeUserPort registerUserPort;
    private final PasswordEncoder passwordEncoder;

    @Override
    public YoungLifeUserModel registerYoungLifeUser(String email, String password, String firstName, String lastName) {
        YoungLifeUserModel youngLifeUserModel = findUserPort.loadByEmail(email);
        if(youngLifeUserModel == null) {
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
