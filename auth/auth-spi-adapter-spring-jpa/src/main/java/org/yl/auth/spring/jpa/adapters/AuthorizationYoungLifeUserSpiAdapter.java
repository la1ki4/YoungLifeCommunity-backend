package org.yl.auth.spring.jpa.adapters;

import org.springframework.stereotype.Component;
import org.yl.auth.model.YoungLifeUserModel;
import org.yl.auth.spi.login.YoungLifeUserAuthorizationSpi;
import org.yl.auth.spring.jpa.repositories.JpaYoungLifeUserRepository;

@Component
public class AuthorizationYoungLifeUserSpiAdapter implements YoungLifeUserAuthorizationSpi {
    private final JpaYoungLifeUserRepository jpaYoungLifeUserRepository;

    public AuthorizationYoungLifeUserSpiAdapter(JpaYoungLifeUserRepository jpaYoungLifeUserRepository) {
        this.jpaYoungLifeUserRepository = jpaYoungLifeUserRepository;
    }

    @Override
    public YoungLifeUserModel getUserByEmail(String email) {
        return jpaYoungLifeUserRepository.findYoungLifeUserByEmail(email)
                .map(entity->YoungLifeUserModel
                        .builder()
                        .id(entity.getId())
                        .firstName(entity.getFirstName())
                        .lastName(entity.getLastName())
                        .password(entity.getPassword())
                        .email(entity.getEmail())
                        .createdAt(entity.getCreatedAt())
                        .build()
                )
                .orElse(null);
    }
}
