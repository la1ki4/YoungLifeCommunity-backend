package org.yl.auth.usecase.roles;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.yl.auth.config.security.SecurityRoleProperties;
import org.yl.auth.role.data.UserRoleData;
import org.yl.auth.spi.roles.RoleInitializationSpi;
import org.yl.auth.spi.roles.RoleIsExistByRoleNameSpi;

@Service
@RequiredArgsConstructor
public class YoungLifeUserRoleInitializationUseCase {
    private final RoleInitializationSpi roleInitializationSpi;
    private final RoleIsExistByRoleNameSpi roleIsExistByRoleNameSpi;
    private final SecurityRoleProperties securityRoleProperties;

    @Transactional
    public void initializeRoles() {
        for(UserRoleData userRoleData: securityRoleProperties.getInitialRoles()){
            if(!roleIsExistByRoleNameSpi.roleIsExist(userRoleData.getRole())){
                roleInitializationSpi.addNewRole(userRoleData.getRole(), userRoleData.getPriority());
            }
        }
    }
}
