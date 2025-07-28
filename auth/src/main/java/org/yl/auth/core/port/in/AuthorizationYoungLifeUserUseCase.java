package org.yl.auth.core.port.in;

@FunctionalInterface
public interface AuthorizationYoungLifeUserUseCase {
    boolean authenticateYoungLifeUser(String username, String password);
}
