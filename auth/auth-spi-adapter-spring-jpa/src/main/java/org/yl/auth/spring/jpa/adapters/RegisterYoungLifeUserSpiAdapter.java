package org.yl.auth.spring.jpa.adapters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.yl.auth.spi.register.RegistrationYoungLifeUserSpi;
import org.yl.auth.spring.jpa.entities.YoungLifeUserEntity;
import org.yl.auth.model.YoungLifeUserModel;
import org.yl.auth.spring.jpa.mappers.YoungLifeUserAndRoleMapper;
import org.yl.auth.spring.jpa.repositories.JpaYoungLifeUserRepository;

@Component
@RequiredArgsConstructor
public class RegisterYoungLifeUserSpiAdapter implements RegistrationYoungLifeUserSpi {
    private final JpaYoungLifeUserRepository jpaYoungLifeUserRepository;

    @Override
    public YoungLifeUserModel registerYoungLifeUser(YoungLifeUserModel user) {
        YoungLifeUserEntity entity = YoungLifeUserAndRoleMapper.fromUserModel(user);
        YoungLifeUserEntity saved = jpaYoungLifeUserRepository.save(entity);
        return YoungLifeUserAndRoleMapper.toUserModel(saved);
    }
}
