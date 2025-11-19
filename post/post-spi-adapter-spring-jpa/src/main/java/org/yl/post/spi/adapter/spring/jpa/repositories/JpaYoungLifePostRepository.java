package org.yl.post.spi.adapter.spring.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yl.post.spi.adapter.spring.jpa.entities.YoungLifePostEntity;

import java.util.UUID;

public interface JpaYoungLifePostRepository extends JpaRepository<YoungLifePostEntity, UUID> {
}
