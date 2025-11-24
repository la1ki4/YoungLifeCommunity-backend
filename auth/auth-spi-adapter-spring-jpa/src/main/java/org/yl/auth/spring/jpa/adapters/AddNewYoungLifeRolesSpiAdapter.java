package org.yl.auth.spring.jpa.adapters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.yl.auth.spi.roles.RoleInitializationSpi;
import org.yl.auth.spi.roles.RoleIsExistByRoleNameSpi;
import org.yl.auth.spring.jpa.entities.YoungLifeUserRoleEntity;
import org.yl.auth.spring.jpa.repositories.JpaYoungLifeUserRoleRepository;

@Component
@RequiredArgsConstructor
public class AddNewYoungLifeRolesSpiAdapter implements
        RoleInitializationSpi,
        RoleIsExistByRoleNameSpi {
    private final JpaYoungLifeUserRoleRepository roleRepository;

    @Override
    public void addNewRole(String roleName, int rolePriorityLevel) {
        YoungLifeUserRoleEntity roleEntity = new YoungLifeUserRoleEntity();
        roleEntity.setRoleName(roleName);
        roleEntity.setRolePriorityLevel(rolePriorityLevel);
        roleRepository.save(roleEntity);
    }

    @Override
    public boolean roleIsExist(String roleName) {
        return roleRepository.existsByRoleName(roleName);
    }
}
