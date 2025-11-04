package org.yl.auth.spring.jpa.login;

import org.springframework.stereotype.Component;
import org.yl.auth.model.YoungLifeUserModel;
import org.yl.auth.spi.verifier.YoungLifeUserByEmailSpi;
import org.yl.auth.spring.jpa.JpaYoungLifeUserRepository;

@Component
public class AuthorizationYoungLifeUserAdapterSpi implements YoungLifeUserByEmailSpi {
    private final JpaYoungLifeUserRepository jpaYoungLifeUserRepository;

    public AuthorizationYoungLifeUserAdapterSpi(JpaYoungLifeUserRepository jpaYoungLifeUserRepository) {
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
