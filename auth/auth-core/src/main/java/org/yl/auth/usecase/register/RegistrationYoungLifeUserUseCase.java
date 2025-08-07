package org.yl.auth.usecase.register;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.yl.auth.api.register.RegistrationYoungLifeUserApi;
import org.yl.auth.model.YoungLifeUserModel;
import org.yl.auth.spi.register.RegistrationYoungLifeUserSpi;
import org.yl.auth.spi.verifier.VerifyYoungLifeUserByEmailSpi;

import java.sql.Timestamp;

@AllArgsConstructor
public class RegistrationYoungLifeUserUseCase implements RegistrationYoungLifeUserApi {
    private final VerifyYoungLifeUserByEmailSpi findUserPort;
    private final RegistrationYoungLifeUserSpi registerUserPort;
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
