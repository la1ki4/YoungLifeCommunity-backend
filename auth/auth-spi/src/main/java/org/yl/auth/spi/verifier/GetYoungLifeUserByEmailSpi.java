package org.yl.auth.spi.verifier;

import org.yl.auth.model.YoungLifeUserModel;

@FunctionalInterface
public interface GetYoungLifeUserByEmailSpi {
    YoungLifeUserModel getUserByEmail(String email);
}
