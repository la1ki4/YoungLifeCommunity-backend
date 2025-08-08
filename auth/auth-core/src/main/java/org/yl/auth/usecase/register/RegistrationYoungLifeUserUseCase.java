package org.yl.auth.usecase.register;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.yl.auth.api.register.RegistrationYoungLifeUserApi;
import org.yl.auth.model.YoungLifeUserModel;
import org.yl.auth.spi.register.RegistrationYoungLifeUserSpi;
import org.yl.auth.spi.verifier.GetYoungLifeUserByEmailSpi;

import java.sql.Timestamp;

@AllArgsConstructor
public class RegistrationYoungLifeUserUseCase implements RegistrationYoungLifeUserApi {
    private final GetYoungLifeUserByEmailSpi userRepository;
    private final RegistrationYoungLifeUserSpi registerUserPort;
    private final PasswordEncoder passwordEncoder;

    @Override
    public YoungLifeUserModel registerYoungLifeUser(String email, String password, String firstName, String lastName) {
        YoungLifeUserModel youngLifeUserModel = userRepository.getUserByEmail(email);
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
