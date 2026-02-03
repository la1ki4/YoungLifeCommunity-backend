package org.yl.post.view.spi.adapter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yl.post.view.spi.adapter.entities.PostViewEntity;

import java.util.Optional;
import java.util.UUID;

public interface JpaPostViewRepository extends JpaRepository<PostViewEntity, UUID> {
    boolean existsByUserIdAndPostId(UUID userId, UUID postId);
    long countByPostId(UUID postId);
}
