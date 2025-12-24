package org.yl.post.comment.spi.adapter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yl.post.comment.spi.adapter.entities.CommentEntity;

import java.util.UUID;

public interface JpaCommentRepository extends JpaRepository<CommentEntity, UUID> {
}
