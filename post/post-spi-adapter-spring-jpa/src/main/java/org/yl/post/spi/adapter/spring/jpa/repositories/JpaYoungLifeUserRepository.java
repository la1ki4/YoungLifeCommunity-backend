package org.yl.post.spi.adapter.spring.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yl.post.spi.adapter.spring.jpa.entities.YoungLifeUserEntity;

import java.util.Optional;
import java.util.UUID;

public interface JpaYoungLifeUserRepository extends JpaRepository<YoungLifeUserEntity, UUID> {
    Optional<YoungLifeUserEntity> findByEmail(String email);
}
