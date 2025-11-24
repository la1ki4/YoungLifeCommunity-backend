package org.yl.auth.spring.jpa.adapters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.yl.auth.spi.register.RegistrationYoungLifeUserSpi;
import org.yl.auth.spring.jpa.entities.YoungLifeUserEntity;
import org.yl.auth.model.YoungLifeUserModel;
import org.yl.auth.spring.jpa.entities.YoungLifeUserRoleEntity;
import org.yl.auth.spring.jpa.mappers.YoungLifeUserAndRoleMapper;
import org.yl.auth.spring.jpa.repositories.JpaYoungLifeUserRepository;
import org.yl.auth.spring.jpa.repositories.JpaYoungLifeUserRoleRepository;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RegisterYoungLifeUserSpiAdapter implements RegistrationYoungLifeUserSpi {
    private final JpaYoungLifeUserRepository userRepository;
    private final JpaYoungLifeUserRoleRepository roleRepository;

    @Override
    public YoungLifeUserModel registerYoungLifeUser(YoungLifeUserModel user) {
        YoungLifeUserEntity userEntity = YoungLifeUserAndRoleMapper.fromUserModel(user);
        Optional<YoungLifeUserRoleEntity> roleEntity = roleRepository.findByRoleName("User");
        userEntity.setUserRole(roleEntity.orElse(null));
        YoungLifeUserEntity saved = userRepository.save(userEntity);
        return YoungLifeUserAndRoleMapper.toUserModel(saved);
    }
}
