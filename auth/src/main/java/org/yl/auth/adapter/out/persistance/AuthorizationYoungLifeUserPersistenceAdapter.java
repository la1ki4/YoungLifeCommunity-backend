package org.yl.auth.adapter.out.persistance;

import org.springframework.stereotype.Component;
import org.yl.auth.core.model.YoungLifeUserModel;
import org.yl.auth.core.port.out.AuthenticateYoungLifeUserPort;

@Component
public class AuthorizationYoungLifeUserPersistenceAdapter implements AuthenticateYoungLifeUserPort {
    private final JpaYoungLifeUserRepository jpaYoungLifeUserRepository;

    public AuthorizationYoungLifeUserPersistenceAdapter(JpaYoungLifeUserRepository jpaYoungLifeUserRepository) {
        this.jpaYoungLifeUserRepository = jpaYoungLifeUserRepository;
    }

    @Override
    public YoungLifeUserModel loadByEmail(String email) {
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
