package org.yl.auth.core.port.in;

import org.yl.auth.core.model.YoungLifeUserModel;

@FunctionalInterface
public interface RegistrationYoungLifeUserUseCase {
    YoungLifeUserModel registerYoungLifeUser(String email, String password, String firstName, String lastName);
}
