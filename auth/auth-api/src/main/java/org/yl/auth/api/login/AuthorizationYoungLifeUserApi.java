package org.yl.auth.api.login;

@FunctionalInterface
public interface AuthorizationYoungLifeUserApi {
    String generateTokenForYoungLifeUser(String username, String password);
}
