package org.yl.post.spi.adapter.spring.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaYoungLifePostRepository extends JpaRepository<YoungLifePostEntity, UUID> {
}
