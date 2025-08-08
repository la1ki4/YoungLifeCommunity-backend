package org.yl.auth.config.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.yl.auth.model.YoungLifeUserModel;
import org.yl.auth.spring.jpa.login.AuthorizationYoungLifeUserAdapterSpi;

import java.util.Collections;

@Service
@AllArgsConstructor
public class YoungLifeUserDetailsService  implements UserDetailsService {
    AuthorizationYoungLifeUserAdapterSpi authorizationYoungLifeUserAdapterSpi;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       YoungLifeUserModel youngLifeUserModel = authorizationYoungLifeUserAdapterSpi.getUserByEmail(email);
       if (youngLifeUserModel == null) {
           throw new UsernameNotFoundException("User not found wit email: " + email);
       }
       return new User(
               youngLifeUserModel.getEmail(),
               youngLifeUserModel.getPassword(),
               Collections.emptyList()
       );
    }
}
