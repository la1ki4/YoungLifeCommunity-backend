package org.yl.auth.usecase.login;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.yl.auth.api.login.AuthorizationYoungLifeUserApi;
import org.yl.auth.util.jwt.JwtUtil;

@AllArgsConstructor
public class AuthorizationYoungLifeUserUseCase implements AuthorizationYoungLifeUserApi {
    JwtUtil jwtUtils;
    AuthenticationManager authenticationManager;


    @Override
    public String generateTokenForYoungLifeUser(String email, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        );
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return jwtUtils.generateToken(userDetails.getUsername());
    }
}
