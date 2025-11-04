package org.yl.auth.spi.verifier;

import org.yl.auth.model.YoungLifeUserModel;

@FunctionalInterface
public interface YoungLifeUserByEmailSpi {
    YoungLifeUserModel getUserByEmail(String email);
}
