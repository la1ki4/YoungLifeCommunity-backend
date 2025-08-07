package org.yl.auth.spring.jpa.register;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.yl.auth.spi.register.RegistrationYoungLifeUserSpi;
import org.yl.auth.spring.jpa.YoungLifeUserEntity;
import org.yl.auth.model.YoungLifeUserModel;
import org.yl.auth.spring.jpa.JpaYoungLifeUserRepository;

@Component
@RequiredArgsConstructor
public class RegistrationYoungLifeUserPersistenceAdapter implements RegistrationYoungLifeUserSpi {
    private final JpaYoungLifeUserRepository jpaYoungLifeUserRepository;

    @Override
    public YoungLifeUserModel registerYoungLifeUser(YoungLifeUserModel user) {
        YoungLifeUserEntity entity = YoungLifeUserEntity.fromModel(user);
        YoungLifeUserEntity saved = jpaYoungLifeUserRepository.save(entity);
        return saved.toModel();
    }
}
