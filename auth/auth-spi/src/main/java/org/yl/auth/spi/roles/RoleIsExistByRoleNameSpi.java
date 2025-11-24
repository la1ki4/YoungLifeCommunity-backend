package org.yl.auth.spi.roles;

@FunctionalInterface
public interface RoleIsExistByRoleNameSpi {
    boolean roleIsExist(String roleName);
}
