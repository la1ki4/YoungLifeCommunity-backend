package org.yl.auth.core.service;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.yl.auth.core.model.YoungLifeUserModel;
import org.yl.auth.core.port.in.AuthorizationYoungLifeUserUseCase;
import org.yl.auth.core.port.out.AuthenticateYoungLifeUserPort;

@AllArgsConstructor
public class AuthorizationYoungLifeUserService implements AuthorizationYoungLifeUserUseCase {
    private final AuthenticateYoungLifeUserPort loadUserPort;
    private final PasswordEncoder passwordEncoder;

    @Override
    public boolean authenticateYoungLifeUser(String email, String password) {
        YoungLifeUserModel youngLifeUserModel = loadUserPort.loadByEmail(email);
        return youngLifeUserModel != null && passwordEncoder.matches(password, youngLifeUserModel.getPassword());
    }
}
