package org.yl.calendar.event.spi.adapter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yl.calendar.event.spi.adapter.entities.UserEntity;

import java.util.Optional;
import java.util.UUID;

public interface JpaUserRepository extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findYoungLifeUserByEmail(String userEmail);
}
