package org.yl.auth.spi.roles;

@FunctionalInterface
public interface RoleInitializationSpi {
    void addNewRole(String roleName, int rolePriority);
}
