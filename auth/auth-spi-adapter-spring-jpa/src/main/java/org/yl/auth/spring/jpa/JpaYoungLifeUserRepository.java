package org.yl.auth.spring.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface JpaYoungLifeUserRepository extends JpaRepository<YoungLifeUserEntity, UUID> {
    Optional<YoungLifeUserEntity> findYoungLifeUserByEmail(String email);
}
