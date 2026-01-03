package org.yl.auth.api.login;

import java.util.List;
import java.util.Optional;

@FunctionalInterface
public interface AuthUserExceptionsApi {
    Optional<List<String>> authorizationException(String userEmail, String userPassword);
}
