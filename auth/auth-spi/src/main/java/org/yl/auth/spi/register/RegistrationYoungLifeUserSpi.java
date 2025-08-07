package org.yl.auth.spi.register;

import org.yl.auth.model.YoungLifeUserModel;

public interface RegistrationYoungLifeUserSpi {
    YoungLifeUserModel registerYoungLifeUser(YoungLifeUserModel user);
}
