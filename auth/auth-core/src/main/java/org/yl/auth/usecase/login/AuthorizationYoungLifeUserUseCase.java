package org.yl.auth.usecase.login;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.yl.auth.api.login.AuthorizationYoungLifeUserApi;
import org.yl.auth.model.YoungLifeUserModel;
import org.yl.auth.spi.verifier.VerifyYoungLifeUserByEmailSpi;

@AllArgsConstructor
public class AuthorizationYoungLifeUserUseCase implements AuthorizationYoungLifeUserApi {
    private final VerifyYoungLifeUserByEmailSpi getYoungLifeUserByEmailSpi;
    private final PasswordEncoder passwordEncoder;

    @Override
    public boolean authenticateYoungLifeUser(String email, String password) {
        YoungLifeUserModel youngLifeUserModel = getYoungLifeUserByEmailSpi.loadByEmail(email);
        return youngLifeUserModel != null && passwordEncoder.matches(password, youngLifeUserModel.getPassword());
    }
}
