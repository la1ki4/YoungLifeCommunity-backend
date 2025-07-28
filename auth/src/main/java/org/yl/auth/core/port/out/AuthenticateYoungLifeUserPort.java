package org.yl.auth.core.port.out;

import org.yl.auth.core.model.YoungLifeUserModel;

@FunctionalInterface
public interface AuthenticateYoungLifeUserPort {
    YoungLifeUserModel loadByEmail(String email);
}
