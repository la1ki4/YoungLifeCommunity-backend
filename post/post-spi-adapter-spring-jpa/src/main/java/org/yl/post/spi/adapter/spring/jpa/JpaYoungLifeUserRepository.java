package org.yl.post.spi.adapter.spring.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface JpaYoungLifeUserRepository extends JpaRepository<YoungLifeUserEntity, UUID> {
    Optional<YoungLifeUserEntity> findByEmail(String email);
}
