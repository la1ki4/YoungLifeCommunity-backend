package org.yl.auth.usecase.login;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.yl.auth.api.login.AuthUserExceptionsApi;
import org.yl.auth.model.YoungLifeUserModel;
import org.yl.auth.spi.login.YoungLifeUserAuthorizationSpi;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

public record AuthorizationUserExceptionsUseCase(YoungLifeUserAuthorizationSpi userRepository,
                                                 PasswordEncoder passwordEncoder) implements AuthUserExceptionsApi {

    @Override
    public Optional<List<String>> authorizationException(String userEmail, String userPassword) {
        List<String> exceptions = new ArrayList<>();
        if(userEmail.isEmpty()){
            exceptions.add("Please enter your e-mail");
        }

        if(!validateEmail(userEmail) && !userEmail.isEmpty()){
            exceptions.add("Expected e-mail format: name@example.com");
        }

        if(userPassword.isEmpty()){
            exceptions.add("Please enter your password");
            return Optional.of(exceptions);
        }
        YoungLifeUserModel userModel = userRepository.getUserByEmail(userEmail);

        if(!validateEmail(userEmail)){
            return Optional.of(exceptions);
        }

        if(userModel == null && !userEmail.isEmpty()){
            exceptions.add("This e-mail address was not found");
        }

        if(userModel != null && !passwordEncoder.matches(userPassword, userModel.getPassword())) {
            exceptions.add("Incorrect password");
        }
        return Optional.of(exceptions);
    }

    private static final Pattern EMAIL_PATTERN = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");

    private static boolean validateEmail(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }
}
