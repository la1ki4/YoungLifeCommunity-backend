package org.yl.auth.api.register;

import org.yl.auth.model.YoungLifeUserModel;

@FunctionalInterface
public interface RegistrationYoungLifeUserApi {
    YoungLifeUserModel registerYoungLifeUser(String email, String password, String firstName, String lastName);
}
