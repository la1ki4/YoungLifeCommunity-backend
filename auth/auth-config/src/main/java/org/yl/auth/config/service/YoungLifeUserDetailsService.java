package org.yl.auth.config.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.yl.auth.model.YoungLifeUserModel;
import org.yl.auth.spring.jpa.adapters.AuthorizationYoungLifeUserSpiAdapter;

import java.util.Collections;

@Service
@AllArgsConstructor
public class YoungLifeUserDetailsService  implements UserDetailsService {
    AuthorizationYoungLifeUserSpiAdapter authorizationYoungLifeUserSpiAdapter;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       YoungLifeUserModel youngLifeUserModel = authorizationYoungLifeUserSpiAdapter.getUserByEmail(email);
       if (youngLifeUserModel == null) {
           throw new UsernameNotFoundException("User not found with email: " + email);
       }
       return new User(
               youngLifeUserModel.getEmail(),
               youngLifeUserModel.getPassword(),
               Collections.emptyList()
       );
    }
}
