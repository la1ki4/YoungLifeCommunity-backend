package org.yl.auth.spi.login;

import org.yl.auth.model.YoungLifeUserModel;

@FunctionalInterface
public interface YoungLifeUserAuthorizationSpi {
    YoungLifeUserModel getUserByEmail(String email);
}
