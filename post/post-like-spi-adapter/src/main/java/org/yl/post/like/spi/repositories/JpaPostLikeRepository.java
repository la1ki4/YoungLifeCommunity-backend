package org.yl.post.like.spi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yl.post.like.spi.entities.PostLikeEntity;
import java.util.Optional;
import java.util.UUID;

public interface JpaPostLikeRepository extends JpaRepository<PostLikeEntity, UUID> {
    Optional<PostLikeEntity> findByPostIdAndUserId(UUID postId, UUID userId);
    long countByPostId(UUID postId);
    boolean existsByPostIdAndUserId(UUID postId, UUID userId);
}
