package org.yl.auth.api.login;

@FunctionalInterface
public interface AuthorizationYoungLifeUserApi {
    boolean authenticateYoungLifeUser(String username, String password);
}
