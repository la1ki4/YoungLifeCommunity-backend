package org.yl.auth.spring.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yl.auth.spring.jpa.entities.YoungLifeUserRoleEntity;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface JpaYoungLifeUserRoleRepository extends JpaRepository<YoungLifeUserRoleEntity, UUID> {
    boolean existsByRoleName(String roleName);
    Optional<YoungLifeUserRoleEntity> findByRoleName(String roleName);
}