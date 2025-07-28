package org.yl.auth.adapter.out.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface JpaYoungLifeUserRepository extends JpaRepository<YoungLifeUserEntity, UUID> {
    Optional<YoungLifeUserEntity> findYoungLifeUserByEmail(String email);
}
