package org.yl.post.comment.spi.adapter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yl.post.comment.spi.adapter.entities.CommentEntity;

import java.util.List;
import java.util.UUID;

public interface JpaCommentRepository extends JpaRepository<CommentEntity, UUID> {
    List<CommentEntity> findByPostIdOrderByCreatedAtAsc(UUID postId);
    long countByPostId(UUID postId);
}
